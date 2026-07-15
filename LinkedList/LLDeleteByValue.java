public class LLDeleteByValue {
    public static void main(String[] args) {
        Node first = new Node(23);
        Node second = new Node(34);
        Node third = new Node(54);
        Node fourth = new Node(76);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node head = first;

        int value = 34;
        // special cases
        if(head != null && head.data == value){
            head = head.next;
        }else{
            Node current = head;
            // find the before node of the value
            while(current.next != null && current.next.data != value){
                current = current.next;
            }
            // change the reference to the current node address to next to next node
            if(current.next != null){
                current.next = current.next.next;
            }
        }
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println("END");
    }
}
