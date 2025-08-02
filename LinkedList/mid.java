package LinkedList ; 
import java.util.*;
class Node {
    int data  ; 
    Node head , next ; 
    public Node(int data){
        this.data = data ; 
        this.next = null ; 
    }
}
public class mid {
    public Node findmid(Node head){
        Node slow   = head ; 
        Node fast =head ; 
        if(head ==null || head.next == null){
            return head ;
        }
        while(fast != null && fast.next != null){
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        return slow ;
    }
    public void append(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }
    public static void main(String[] args) {
        mid obj = new mid();
        obj.append(1);
        obj.append(2);
        obj.append(3);
        obj.append(4);
        obj.append(5);
        Node midNode = obj.findmid(obj.head);
        if (midNode != null) {
            System.out.println( midNode.data);
        } else {
            System.out.println("List is empty.");
        }
    }
}