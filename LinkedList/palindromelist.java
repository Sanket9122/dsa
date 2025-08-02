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
public class palindromelist {
    public boolean isPalindrome (Node head){
        Node curr = head ;
        ArrayList<Integer> list = new ArrayList<>() ;
        while (curr!=null){
            list.add(curr.val);
            curr = curr.next ;
        }
        List<Integer> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);
        return list.equals(reverseList);
    }
    public static void main(String[] args) {
        palindromelist obj = new palindromelist();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(obj.isPalindrome(head));
    }
}
