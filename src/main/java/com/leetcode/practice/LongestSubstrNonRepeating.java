package com.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrNonRepeating {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() <=1){
            return s.length();
        }

        int longest=0;



        for(int i=0;i<s.length();i++){
            int currentlength=0;
            Set<Character> characters= new HashSet<>();
            for(int j=i;j<s.length();j++){

            Character ch = s.charAt(j);
            if(!(characters.contains(ch))){
                characters.add(ch);
                currentlength++;
                if(longest < currentlength){
                    longest = currentlength;
                }
            }else{
                break;
            }}
        }


        return longest;
    }

    public static void main(String[] args) {

        LongestSubstrNonRepeating longestSubstrNonRepeating= new LongestSubstrNonRepeating();
        System.out.println(longestSubstrNonRepeating.lengthOfLongestSubstring("abcabcbb"));


    }
}
