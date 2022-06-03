package com.leetcode.practice;

public class BinarySearch {

    public int binarysearch(int []nums,int left,int right,int target){
        while(left<=right){
            int mid= (int) Math.floor((left+right)/2);
            int foundVal=nums[mid];
            if(foundVal==target){
                return mid;
            }else if(foundVal<target){
                left=mid+1;
            }else{
                right =mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0){
            return new int[]{-1, -1};
        }
        int firstPos = binarysearch(nums,0,nums.length-1,target);
        if(firstPos==-1){
            return new int[]{-1, -1};
        }
        int startPos=firstPos;
        int endPos=firstPos;
        int temp1 = -1;int temp2=-1;
        while(startPos!=-1){
            temp1=startPos;
            startPos=binarysearch(nums,0,startPos-1,target);
        }
        startPos=temp1;

        while(endPos!=-1){
            temp2=endPos;
            endPos=binarysearch(nums,endPos+1,nums.length-1,target);
        }
        endPos=temp2;

        return new int[]{startPos, endPos};
    }
}
