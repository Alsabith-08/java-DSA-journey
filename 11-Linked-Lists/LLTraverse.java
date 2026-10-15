

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

public class LLTraverse {
    public static void main(String[] args) {

        Node first = new Node(12);
        Node second = new Node(17);
        Node third = new Node(13);

        first.next = second;
        second.next = third;

        Node head = first;

        Node current  = head;

        while(current != null){

            System.out.print(current.data + " -> ");

            current = current.next;
        }
        System.out.println("END");
    }

}
