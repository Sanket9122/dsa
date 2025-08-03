package LinkedList;
import java.util.*;
class Node {
    int value;  
    Node next;
    public Node (int value){
        this.value = value; 
        this.next = null;
    }
}
public class removeLL {
    public Node removeNodes(Node head, int val) {
        Node dummy = new Node (0);
        Node prev = dummy ; 
        Node curr = head;
        dummy.next = head;
        while(curr!=null){
            if(curr.value == val)
            {
                prev.next  = curr.next ; 
                curr = curr.next ;
            }
            else {
                prev = curr;
                curr = curr.next ;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        removeLL r = new removeLL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new Node(13);
        head.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(14);
        Node result = r.removeNodes(head, 3);
        if (result != null) {
            System.out.println(result.value);
        } else {
            System.out.println("List is empty after removal");
        }
    }
}
