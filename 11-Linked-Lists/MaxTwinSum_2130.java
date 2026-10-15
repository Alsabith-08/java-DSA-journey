
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
// Approach : slipt into half , reverse the second half then add linearly to get the max sum
// Time Complexity : O(n) , Space Complexity : O(1)
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
