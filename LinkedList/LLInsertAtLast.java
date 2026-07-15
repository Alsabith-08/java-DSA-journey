package ChatGPT_Problems.LinkedList;

public class LLInsertAtLast {
    public static void main(String[] args) {

        Node first = new Node(12);
        Node second = new Node(43);
        Node third  = new Node(65);
        Node fourth = new Node(78);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node newNode = new Node(76);

        Node head = first;
        Node current = head;

        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;

        current = head;

        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println("End");
    }
}
