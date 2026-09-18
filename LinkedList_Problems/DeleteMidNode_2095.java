package LeetCodeEx.LinkedList;

public class DeleteMidNode_2095 {
    public static void main(String[] args) {

        ListNode head = null;

        head = addNode(head ,1);
        head = addNode(head ,2);
        head = addNode(head ,3);
        head = addNode(head ,4);
        head = addNode(head ,5);

        System.out.println("Before : ");
        printList(head);

        head = delMid(head);

        System.out.println("After : ");
        printList(head);
    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    static ListNode addNode(ListNode head , int val){

        ListNode newNode =new ListNode(val);

        if(head == null){
            return newNode;
        }

        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    static ListNode delMid(ListNode head){

        if(head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    static void printList(ListNode head){

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if(current.next != null){
                System.out.print(" -> ");
            }

            current = current.next;
        }
        System.out.println("-> Null");
    }
}
