package ChatGPT_Problems.LinkedList;

public class LLFindMiddleNode {
    public static void main(String[] args) {
        Node first = new Node(2);
        Node second = new Node(4);
        Node third = new Node(3);
        Node fourth = new Node(5);
        Node fifth = new Node(7);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        Node head = first;

        Node middle = findMiddle(head);
        // print the value of middle which is point by slow
        System.out.println(middle.data);
    }
    static Node findMiddle(Node head){
        // initial state of slow and fast
        Node slow = head;
        Node fast = head;

        // if fast == null && fast next == null
        // then slow reaches the middle node
        // why ? - slow moves 1 forward and fast moves 2 steps forward
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
