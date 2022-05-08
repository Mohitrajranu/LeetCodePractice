package com.leetcode.practice;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {

        int indexTofind = nums.length - k;

        quickSort(nums,0,nums.length-1);
        return nums[indexTofind];
    }
    public void quickSort(int[] nums,int left ,int right){
        if(left < right){
            int partitionIdx= partition(nums,left,right);
            quickSort(nums,left,partitionIdx-1);
            quickSort(nums,partitionIdx+1,right);

        }
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
