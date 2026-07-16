public class LLDetectCycle {
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

        // create a cycle
        fifth.next = third;

        Node head = first;

        System.out.println(findCycle(head));

    }
    static boolean findCycle(Node head){
        // initial slow and fast point to the head node
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            // if the linkedList is linear or not a cycle return false
            // because in linear linkedList there is null is must
            // if null is present there is not a cycle
            slow = slow.next;
            fast = fast.next.next;

            // if cycle present this two pointer will be meet compulsory
            // then return true
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
