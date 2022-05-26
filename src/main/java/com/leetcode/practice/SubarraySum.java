package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int prefixSum=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for (int i = 0; i <nums.length ; i++) {
            prefixSum+=nums[i];
            ans+=mp.getOrDefault(prefixSum-k,0);
            mp.put(prefixSum,mp.getOrDefault(prefixSum,0)+1);
        }


        return ans;
    }
}
