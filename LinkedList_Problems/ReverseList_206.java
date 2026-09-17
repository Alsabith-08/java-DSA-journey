
// https://leetcode.com/problems/reverse-linked-list/description/
// Approach : 
public class ReverseList_206 {
    public static void main(String[] args) {
        ListNode head = null;

        head = addNode(head , 1);
        head = addNode(head, 2);
        head = addNode(head , 3);
        head = addNode(head , 4);
        head = addNode(head ,5);


        System.out.println("Before : ");
        printList(head);

        head = reverseList(head);

        System.out.println("After : ");
        printList(head);
    }
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    // add Nodes
    public static ListNode addNode( ListNode head , int val){

        ListNode newNode = new ListNode(val);

        if(head == null){
            return newNode;
        }

        ListNode current = head;              // go to last node

        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;             // add the newNode at the end
        return head;
    }
    //  ----------------------------reverse function -------------------------------------
    static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){

            ListNode next = current.next;    // Save the next Node
            current.next = prev;             // Reverse the link
            prev = current;                  // move prev
            current = next;                  // move current
        }
        return prev;
    }
    // print the nodes
    static void printList(ListNode head){

        while(head != null){
            System.out.print(head.val);

            if(head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println(" -> NULL ");
    }
}
