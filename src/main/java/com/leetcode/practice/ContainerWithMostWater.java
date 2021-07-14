package com.leetcode.practice;
import java.lang.Integer.*;
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int area = 0,i=0,j=height.length-1;
       while(i<j) {
            int temparea = Integer.min(height[i], height[j]) * (j -i);
            area= Integer.max(area,temparea);
            if(height[j]>= height[i]){
                i++;
            }else{
                j--;
            }



        }
        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        //1,8,6,2,5,4,8,3,7
        int []height = {7,3,8,4,5,2,6,8,1};
        System.out.println(cwmw.maxArea(height));
    }
}
