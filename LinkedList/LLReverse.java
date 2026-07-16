package ChatGPT_Problems.LinkedList;

public class LLReverse {
    public static void main(String[] args) {
        Node first = new Node(2);
        Node second = new Node(4);
        Node third = new Node(3);

        first.next = second;
        second.next = third;

        Node head = first;

        // why we use three pointers ?
        // prev    - remember the previous node
        // current - which node is currently processing
        // next    - save the node before changing the link
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            // 1. save the current.next node in next
            next = current.next;

            // 2. change the link to previous
            current.next = prev;

            // 3. move forward the prev and the current
            prev = current;
            current = next;
        }
        // then prev is my new head
        head = prev;

        // for traverse use the current node , because head will point to the first node
        current = head;

        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }
}
