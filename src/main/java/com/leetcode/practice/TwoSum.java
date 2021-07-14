package com.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
     int[] resarr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i =0;i < nums.length ;i++){
            int numTofind = target - nums[i];
            if(map.containsKey(numTofind)){
                resarr[0]=map.get(numTofind);
                resarr[1]=i;
                return resarr;
            }else{
                map.put(nums[i],i);
            }

        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int []nums = {2,7,9,11,13};
        int target = 11;
        twoSum.twoSum(nums,target);
        Arrays.stream(twoSum.twoSum(nums,target)).forEach(System.out::println);
    }
}
