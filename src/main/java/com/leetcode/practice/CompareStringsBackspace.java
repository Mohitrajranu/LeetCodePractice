package com.leetcode.practice;

import java.util.Stack;

public class CompareStringsBackspace {

    public boolean backspaceCompare(String s, String t) {

        String s1 =  CompareStringsBackspace.finalString(s);
        String s2 = CompareStringsBackspace.finalString(t);

        if(s1.length() != s2.length()){
            return false;
        }else{
            for (int i=0; i<s1.length();i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static String finalString(String str){
        Stack<String> strings = new Stack<>();
        for (int i=0;i<str.length();i++){
            if(Character.toString(str.charAt(i)).equalsIgnoreCase("#")){
                if(strings.size() > 0){
                    strings.pop();
                }

            }else{
                strings.push(Character.toString(str.charAt(i)));
            }
        }
        return strings.toString();
    }

    public static void main(String[] args) {
        CompareStringsBackspace compareStringsBackspace = new CompareStringsBackspace();
        System.out.println(compareStringsBackspace.backspaceCompare("ab##","c#d#"));
        
    }
}
