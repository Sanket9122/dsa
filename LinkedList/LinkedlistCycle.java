package LinkedList;
import java.util.*;
class Node {
    int val ; 
    Node head ;
    Node next;
    public Node(int val) {
        this.val = val ;
        this.head = null ;
        this.next = null ;
    }
}
public class LinkedlistCycle{
    public boolean hascycle (Node head){
        if(head == null) {
            return false ;
        }
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
           if(fast==slow){
            return true;
          }
        }
          return false;
    }
    public static void main(String[] args) {
        
    }
}