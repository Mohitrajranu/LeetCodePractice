package com.leetcode.practice;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> threeSum = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length - 2;i++){
            if (i > 0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            int val = -(nums[i]);
            while(j<k){
                if(nums[j]+nums[k] > val){
                    k--;
                }else if(nums[j]+nums[k] < val){
                   j++ ;
                }else{
                    List<Integer> sum = new ArrayList<>();
                    sum.add(nums[i]);
                    sum.add(nums[j]);
                    sum.add(nums[k]);
                    threeSum.add(sum);
                    while (j<k && nums[j]==nums[j+1]) j++;
                    while (j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;

                }
            }
        }
        return threeSum;

    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int []nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> sum= threeSum.threeSum(nums);
        for (List<Integer>sum1: sum){
            sum1.forEach(s-> System.out.println(s));
        }
        System.out.println(sum.size());
    }
}
