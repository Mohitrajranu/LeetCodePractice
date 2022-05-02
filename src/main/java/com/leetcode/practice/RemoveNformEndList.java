package com.leetcode.practice;

public class RemoveNformEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int currentpos=0;
        int size=0;
        ListNode tempNode=head;
        ListNode start=null;
        while(tempNode!=null){
            size++;
            tempNode=tempNode.next;
        }
        if(size<n){
            return head;
        }else if(size==n){
            return head.next;
        }else{
            int diff=size-n;
            ListNode currentNode=head;
            while(currentpos<diff){
                start=currentNode;
                currentNode=currentNode.next;
                currentpos++;
            }

            ListNode tail=currentNode.next;
            start.next=tail;
        }

        return head;

    }
}