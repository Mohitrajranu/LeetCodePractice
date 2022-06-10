package com.leetcode.practice;

import java.util.Arrays;

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int total=Arrays.stream(nums).sum();
        int max=subarraysum(nums);
        int min=subarraysum(Arrays.stream(nums).map(i->-i).toArray());
        return max>0?Math.max(max,total+min):max;

    }

    public int subarraysum(int[] nums){
        int max=nums[0];
        int currmax=nums[0];
        for(int i=1;i<nums.length;i++){
            currmax=Math.max(currmax+nums[i],nums[i]);
            max=Math.max(currmax,max);
        }
        return max;
    }
}
