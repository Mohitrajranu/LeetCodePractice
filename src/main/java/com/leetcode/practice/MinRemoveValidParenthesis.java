package com.leetcode.practice;

import java.util.Arrays;
import java.util.Stack;

public class MinRemoveValidParenthesis {
    public String minRemoveToMakeValid(String s) {

        String[] stArr = s.split("");
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<stArr.length;i++){
            if(stArr[i].equals("(")){
                st.push(i);
            }else if(stArr[i].equals(")") && !st.isEmpty()){
                st.pop();
            }else if(stArr[i].equals(")")){
                stArr[i]="";
            }
        }
        while(!st.isEmpty()){
            int index=st.pop();
            stArr[index]="";
        }
        String result= String.join("",stArr);
       return String.join("",stArr);
    }
}
