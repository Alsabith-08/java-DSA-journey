
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}


public class LLSearchValue {
    public static void main(String[] args) {

        // Search Values

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

        int searchKey = 17;
        boolean found = false;

        while(current != null){
            if(current.data == searchKey){
                found = true;
                break;
            }
            current = current.next;
        }
        if(found){
            System.out.println("Element is found");
        }else{
            System.out.println("Element is not found");
        }

    }
}
