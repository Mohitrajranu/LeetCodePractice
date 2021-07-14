package com.leetcode.practice;

public class TrappingRainWater {

    public int trap(int[] height){
        int totalWater = 0;
        int left=0, right=height.length-1;
        int maxLeft=0, maxRight=0;
        while(left < right){

            if(height[left] <= height[right] ){
                if(maxLeft <= height[left]){
                    maxLeft = height[left];
                }else{
                    totalWater+= maxLeft - height[left];
                }
                left ++;
            }else if(height[left] > height[right]){
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }else{
                    totalWater+= maxRight - height[right];
                }


                right--;
            }
        }
        return totalWater;
    }
    public int trapBruteForce(int[] height) {
        int totalWater = 0;
        for(int i =0 ;i<height.length;i++){
            int left=i, right=i;
            int maxLeft=0, maxRight=0;
            while(left>=0){
                maxLeft = Integer.max(maxLeft,height[left]);
                left--;
            }
            while(right < height.length){
                maxRight = Integer.max(maxRight,height[right]);
                right++;
            }
            int currentwater = Integer.min(maxLeft,maxRight)-height[i];
            if(currentwater >= 0){
                totalWater+=currentwater;
            }
        }

        return totalWater;

    }

    public static void main(String[] args) {
        TrappingRainWater tr = new TrappingRainWater();
        int [] height= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(tr.trap(height));
    }
}
