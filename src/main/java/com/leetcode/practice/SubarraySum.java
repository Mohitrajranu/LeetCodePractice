package com.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0, prev = 0;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = (k != 0) ? sum % k : sum;

            if(set.contains(temp))
                return true;

            set.add(prev);
            prev = temp;
        }

        return false;
    }
}
