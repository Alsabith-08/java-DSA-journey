
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
public class LLInsertAtBegin {
    public static void main(String[] args) {

        Node first = new Node(12);
        Node second = new Node(14);
        Node third = new Node(17);
        Node fourth = new Node(19);
        Node fifth = new Node(20);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // create a new node which is insert at the beginning
        Node sixth = new Node(10);

        Node head = first;

        // these two lines is important for insert at the beginning
        sixth.next = head;
        head = sixth;

        Node current = head;

        // traverse
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println("End");
    }
}
