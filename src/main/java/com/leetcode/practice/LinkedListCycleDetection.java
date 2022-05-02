package com.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode hare = head,tortoise=head;
        while(true){
            hare=hare.next;
            tortoise=tortoise.next;
            if(hare==null||hare.next==null){
                return false;
            }else{
                hare=hare.next;
            }
            if(tortoise==hare){
                break;
            }
        }
       ListNode p1=head,p2=tortoise;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
    public boolean hasCycle1(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode currentNode=head;
        Set seenNodes= new HashSet();
        while(!seenNodes.contains(currentNode)){
            if(currentNode.next==null){
                return  false;
            }
            seenNodes.add(currentNode);
            currentNode=currentNode.next;
        }
        return true;
    }
}
