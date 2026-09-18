package LeetCodeEx.LinkedList;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

/*
   In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known
   as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

   For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
   These are the only nodes with twins for n = 4.
   The twin sum is defined as the sum of a node and its twin.

   Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*/
public class MaxTwinSum_2130 {
    public static void main(String[] args) {

        ListNode head = null;

        head = addNode(head , 1);
        head = addNode(head , 2);
        head = addNode(head , 3);
        head = addNode(head , 4);
        head = addNode(head , 5);
        head = addNode(head , 6);

        System.out.println(maxPair(head));

    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    // Add Node
    public static ListNode addNode(ListNode head,int val){
        ListNode newNode = new ListNode(val);

        if(head == null){
            return newNode;
        }

        ListNode current = head;

        while(current.next != null){
            current  = current.next;
        }

        current.next = newNode;
        return head;
    }

    // Max Twin Pair sum
    static int maxPair(ListNode head){

        // step 1 : find the mid node
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half
        ListNode prev = null;

        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // find the maxSum pair
        int maxSum = 0;
        while(head != null && prev != null){
            maxSum = Math.max(head.val + prev.val , maxSum);
            prev= prev.next;
            head = head.next;
        }

        // return the maxSum
        return maxSum;
    }
}
