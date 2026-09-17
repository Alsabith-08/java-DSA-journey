package LeetCodeEx.LinkedList;

import java.util.List;

// https://leetcode.com/problems/odd-even-linked-list/description/
/*
   Given the head of a singly linked list, group all the nodes with odd indices together followed by
   the nodes with even indices, and return the reordered list.

   The first node is considered odd, and the second node is even, and so on.

   Note that the relative order inside both the even and odd groups should remain as it was in the input.

   You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/
public class OddEvenLinkedList_328 {
    public static void main(String[] args) {

        ListNode head = null;

        head = addNode(head , 1);
        head = addNode(head, 2);
        head = addNode(head , 3);
        head = addNode(head , 4);
        head = addNode(head , 5);


        System.out.println("Before : ");
        printList(head);

        head = oddEvenList(head);

        System.out.println("After : ");
        printList(head);
    }

    // node class
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    // add a newNode at the end of LinkedList
    public static ListNode addNode(ListNode head , int val){

        ListNode newNode = new ListNode(val);     // create a new Node

        if(head == null){                         // check list is empty  , is empty return node
            return newNode;
        }

        ListNode current = head;                 // we use the current variable to add , this store the head

        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        return head;
    }
   //  ----------------------------------------OddEvenList ------------------------------------
    static ListNode oddEvenList(ListNode head){

        if(head == null && head.next == null){       // // check both condition , is occurred nothing to rearrange
            return head;
        }

        ListNode odd = head;               // create three pointers : odd , even
        ListNode even = head.next;

        ListNode evenHead = even;         // why evenHead ? -> at later we connect thr oddList -> evenList

        while(even != null && even.next != null){

            odd.next = even.next;           // this connects the odd nodes and move odd
            odd = odd.next;

            even.next = odd.next;           // move the Even connection and move even
            even = even.next;
        }
        odd.next = evenHead;                // Connect Odd + Even , then return head
        return head;
    }
 // print List
    static void printList(ListNode head){

        while(head != null){
            System.out.print(head.val);

            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println(" ");
    }

}
