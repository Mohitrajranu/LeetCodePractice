package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MandNLinkedListReversal {

    public static List<String> passByrefrenceobj(List<String> head){
        List<String> current=head;
        current.remove("4");
        return head;
    }

    public static void main(String[] args) {
        List<String> head1= new ArrayList<>();
        head1.add("1");
        head1.add("2");
        head1.add("3");
        head1.add("4");

        passByrefrenceobj(head1).forEach(o -> System.out.println(o));
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        int currentpos=1;
        ListNode currentNode=head;
        ListNode start=head;
        while(currentpos<left){
            start=currentNode;
            currentNode=currentNode.next;
            currentpos++;
        }
        ListNode newList=null;
        ListNode tail=currentNode;
        while (currentpos >= left && currentpos <= right){
            ListNode next = currentNode.next;
            currentNode.next=newList;
            newList=currentNode;
            currentNode=next;
            currentpos++;
        }
        start.next=newList;
        tail.next=currentNode;
        if(left>1){
            return head;
        }else{
        return newList;
    }
    }
}
