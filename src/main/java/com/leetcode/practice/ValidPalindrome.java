package com.leetcode.practice;
/*Almost a palindrome */
public class ValidPalindrome {
    public boolean validSubPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {

        int left=0;
        int right=s.length() -1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){

                return (validSubPalindrome(s,left+1,right) || validSubPalindrome(s,left,right-1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.validPalindrome("abcda"));

    }
}
