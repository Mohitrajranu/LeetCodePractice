package com.leetcode.practice;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;

        while(low<high){
            int mid=(int) Math.floor((low+high)/2);
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums={17,4,12,13,5};
        PeakElement pk = new PeakElement();
        int max= pk.findPeakElement(nums);
        System.out.println(max);
    }
}
