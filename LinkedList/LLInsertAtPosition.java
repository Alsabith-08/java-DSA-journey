package ChatGPT_Problems.LinkedList;

public class LLInsertAtPosition {
    public static void main(String[] args) {
        Node first = new Node(13);
        Node second = new Node(54);
        Node third = new Node(32);
        Node fourth = new Node(98);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node newNode = new Node(45);

        Node head = first;
        Node current = head;
        int position = 4;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        current = head;

        while(current != null){
            System.out.print(current.data + " -> " );
            current = current.next;
        }
        System.out.println("END");
    }
}
