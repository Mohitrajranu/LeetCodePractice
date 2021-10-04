package com.leetcode.practice;

import java.util.Stack;

public class CompareStringsBackspace {

    public boolean backspaceCompare(String s, String t) {

        int p1=s.length()-1;
        int p2=t.length()-1;
        while(p1>=0 || p2>=0){
            if((p1>= 0 && Character.toString(s.charAt(p1)).equalsIgnoreCase("#"))
                    || (p2 >=0 && Character.toString(t.charAt(p2)).equalsIgnoreCase("#")) ){
                if (p1>= 0 && Character.toString(s.charAt(p1)).equalsIgnoreCase("#")) {
                    int backcount = 2;
                    while (backcount > 0) {
                        p1--;
                        backcount--;
                        if ( p1 >0 && Character.toString(s.charAt(p1)).equalsIgnoreCase("#")) {
                            backcount = backcount + 2;
                        }
                    }
                }
                if (p2>= 0 && Character.toString(t.charAt(p2)).equalsIgnoreCase("#")) {
                    int backcount = 2;
                    while (backcount > 0) {
                        p2--;
                        backcount--;
                        if ( p2 > 0 && Character.toString(t.charAt(p2)).equalsIgnoreCase("#")) {
                            backcount = backcount + 2;
                        }
                    }
                }


            }else{
                if(p1 >= 0 && p2>=0) {
                    if (!(Character.toString(t.charAt(p2)).equalsIgnoreCase(Character.toString(s.charAt(p1))))) {
                        return false;
                    } else {
                        p2--;
                        p1--;
                    }
                }else{
                    return false;
                }
            }

        }

      /*  String s1 =  CompareStringsBackspace.finalString(s);
        String s2 = CompareStringsBackspace.finalString(t);

        if(s1.length() != s2.length()){
            return false;
        }else{
            for (int i=0; i<s1.length();i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    return false;
                }
            }
        }*/

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
        System.out.println(compareStringsBackspace.backspaceCompare("ab#c","ad#c"));
        
    }
}
