/*  
    Basic Operations in Linked List
    
    Node structure
 1. Insert a node at the beginning.
 2. Insert a node at the end.
 3. Delete the first node.
 4. Delete the last node
 5. Search for an element in a Linked List.
 6. Reverse a Singly Linked List.
 7. Display the Linked List
*/
public class SinglyLinkedList {

    // Node Structure
    static class Node{
        int data;
        Node next;

        // Constructor
        public Node(int data){
            this.data = data;
        }
    }
    // Head of the LinkedList
    Node head;

    // 1. Insert At First - O(1)
    public void insertFirst(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;            // change the head pointer to the newNode
    }

    // 2. Insert At Last - O(n)
    public void insertLast(int data){
        // first create that node
        Node newNode = new Node(data);

        if(head == null){       // check the head is null
            head = newNode;     // if null that node becomes head
            return;
        }
        Node current = head;    // put the head in the current

        while(current.next != null){   // traverse the whole list using that current node , find the last node
            current = current.next;
        }
        current.next = newNode;       // then insert it.
    }


    // 3. Delete First - O(1)
    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;         // change the head Pointer to the next node of the head
    }

    // 4. Delete Last - O(n)
    public void deleteLast(){

        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }
        Node current = head;

        while(current.next.next != null){      // Find the node before the last Node
            current = current.next;
        }
        current.next = null;    // change the last node to null
    }

    // 5. Search Element in LinkedList - Best Case O(1),  Worst Case O(n)
    public boolean search(int key){
        if(head == null){
            return false;
        }
        Node current = head;

        while(current != null){
            if(current.data == key){       // Traverse if node == key return true
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 6. Reverse A LinkedList - O(n)
    public void reverse(){

        Node prev = null;       // the node we're currently processing
        Node current = head;    // the already reversed part
        Node next = null;       // Store the remaining list

        while(current != null){

            // Save - Reverse - Move - Repeat

            next = current.next;    // save the rest of the list

            current.next = prev;    // Reverse the current link

            prev = current;         // Move prev forward

            current = next;         // Move the current forward
        }
        head = prev;  // new Head
    }

    // 7. Display the LinkedList - O(n)
    public void display(){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node current = head;

        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("Null");
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(21);
        list.insertFirst(32);
        list.insertFirst(54);
        list.insertFirst(23);

        list.display();

        // Insert First
        System.out.println("\nInsert First");
        list.insertFirst(10);
        list.display();

        // Insert Last
        System.out.println("\nInsert Last");
        list.insertLast(4);
        list.display();

        // Delete First
        System.out.println("\nDelete First");
        list.deleteFirst();
        list.display();

        // Delete Last
        System.out.println("\nDelete Last");
        list.deleteLast();
        list.display();

        // Search the element
        System.out.println("\nSearch : 54");
        System.out.println(list.search(54));

        // reverse LinkedList
        System.out.println("\nReverse LinkedList");
        list.reverse();
        list.display();


    }
}
