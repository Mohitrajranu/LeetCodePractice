package com.leetcode.practice;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head==null ||head.next==null)
            return head;
     ListNode prev=null;
     ListNode current=head;
     while(current!=null){
         ListNode next=current.next;
         current.next=prev;
         prev=current;
         current=next;

     }
      return  prev;
    }

    public static void main(String[] args) {






        ListNode five= new ListNode(5);
        ListNode four= new ListNode(4,five);
        ListNode three= new ListNode(3,four);
        ListNode two= new ListNode(2,three);
        ListNode one= new ListNode(1,two);
        System.out.println(reverseList(one));
    }
}
class ListNode {
     int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }