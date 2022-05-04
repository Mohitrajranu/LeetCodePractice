package com.leetcode.practice;

public class SelectionSort {
    public int[] selectionSort(int[] array){
        int len=array.length;
        for (int i=0;i<len-1;i++){
            int min=i;

            for (int j=i+1;j<len;j++){
                if(array[j]<array[min]){

                    min=j;
                }

            }
            int temp=array[min];
            array[min]=array[i];
            array[i]=temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array={99,44,6,2,1,100,98};
        SelectionSort bs=new SelectionSort();
        for (int i : bs.selectionSort(array)) {
            System.out.println(i);
        }

    }
}
