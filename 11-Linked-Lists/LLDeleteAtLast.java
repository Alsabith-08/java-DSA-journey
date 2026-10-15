public class LLDeleteAtLast {
    public static void main(String[] args) {
        Node first = new Node(23);
        Node second = new Node(34);
        Node third = new Node(54);
        Node fourth = new Node(76);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;
        Node current = head;
        // stop the second last node to delete it
        while(current.next.next != null ){
            current = current.next;
        } 
        // delete it ,then that node will be delete
        current.next = null;

        current = head;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println("END");
    }
}
