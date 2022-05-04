package com.leetcode.practice;

public class InsertionSort {
    public int[] insertionSort(int[] array){
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        int [] array={99,44,6,2,1,100,98};
        InsertionSort bs=new InsertionSort();
        for (int i : bs.insertionSort(array)) {
            System.out.println(i);
        }

    }
}
