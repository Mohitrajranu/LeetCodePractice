package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {

        Map<String,String> params=new HashMap<>();
        params.put("(",")");
        params.put("{","}");
        params.put("[","]");
        if(s.length()<=0){
            return true;
        }
        String[] stArr = s.split("");
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(params.get(stArr[i]) !=null){
                st.push(stArr[i]);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                String leftBracket=st.pop();
                String correctBracket=params.get(leftBracket);
                if(!stArr[i].equals(correctBracket)){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis vp =new ValidParenthesis();
        System.out.println(vp.isValid("()"));
    }
}
