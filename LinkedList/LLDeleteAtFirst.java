public class LLDeleteAtFirst {
    public static void main(String[] args) {
        
        Node first = new Node(23);
        Node second = new Node(34);
        Node third = new Node(54);
        Node fourth = new Node(76);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;
        // just change the head reference to delete the first node 
        head = head.next;
        Node current = head;

        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println("End");
    }
}
