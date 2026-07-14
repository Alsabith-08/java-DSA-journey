package ChatGPT_Problems.LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
public class LLCountNodes {
    public static void main(String[] args) {

        // Traverse the LinkedList
        int count = 0;

        Node first = new Node(12);
        Node second = new Node(14);
        Node third = new Node(17);
        Node fourth = new Node(19);
        Node fifth = new Node(20);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        Node head = first;

        Node current = head;

        while(current != null){

            count ++;
            current = current.next;
        }
        System.out.println(count);
    }
}
