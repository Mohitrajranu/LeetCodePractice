package com.leetcode.practice;

public class DupliacteNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;

    }
}
