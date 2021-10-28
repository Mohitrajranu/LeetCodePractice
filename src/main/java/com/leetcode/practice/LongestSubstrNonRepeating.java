package com.leetcode.practice;


import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstrNonRepeating {

    public int optlengthOfLongestSubstring(String s) {
        if(s.length() <=1){
            return s.length();
        }

        int longest=0;
        Map<Character,Integer> seenChar= new HashMap<>();
        int left=0;
        for(int right=0;right<s.length();right++) {

            Character ch = s.charAt(right);
            if(seenChar.containsKey(ch)) {
                int prevSeen = seenChar.get(ch);
                if (prevSeen >= left) {
                    left = prevSeen + 1;
                }
            }
            seenChar.put(ch,right);
            longest = Math.max(longest,right-left+1);


        }


        return longest;
    }

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
        System.out.println(longestSubstrNonRepeating.optlengthOfLongestSubstring("abcabcbb"));


    }
}
