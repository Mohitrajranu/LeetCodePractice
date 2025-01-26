package com.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,4,5,4,6,1};
        Set<Integer> duplicates = new HashSet<>();
        List<Integer> dupNums = Arrays.stream(nums).filter(value -> !duplicates.add(value)).boxed().collect(Collectors.toList());
        System.out.println(dupNums);
    }
}
