package com.leetcode.practice;

public class KthLargeQuickSelectElement {
    public int findKthLargeQuickSelectElement(int[] nums, int k) {

        int indexTofind = nums.length - k;
        return quickSelect(nums,0,nums.length-1,indexTofind);
    }
    public int quickSelect(int[] nums,int left ,int right,int indexTofind){
        if(left < right){
            int partitionIdx= partition(nums,left,right);
            if(partitionIdx == indexTofind){
                return nums[partitionIdx];
            }else if(indexTofind < partitionIdx) {
                return quickSelect(nums, left, partitionIdx - 1,indexTofind);
            }else {
              return   quickSelect(nums, partitionIdx + 1, right,indexTofind);
            }

        }
        return nums[left];
    }
    public int partition(int[] nums,int left ,int right){
        int pivotElement = nums[right];
        int partitionIdx=left;
        for (int i=left;i<right;i++){
            if(nums[i] <pivotElement){
                swap(nums, partitionIdx, i);
                partitionIdx++;
            }
        }
        swap(nums, partitionIdx, right);
        return partitionIdx;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
}
