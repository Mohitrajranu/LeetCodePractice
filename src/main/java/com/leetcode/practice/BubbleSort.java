package com.leetcode.practice;

public class BubbleSort {
    public int[] bubbleSort(int[] array){
        int len=array.length;
        boolean swapped=false;
        for (int i=0;i<len-1;i++){
            swapped=false;
            for (int j=0;j<len-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swapped=true;
                }

            }
            if(!swapped){
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array={99,44,6,2,1};
        BubbleSort bs=new BubbleSort();
        for (int i : bs.bubbleSort(array)) {
            System.out.println(i);
        }

    }
}
