import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class deletemid{
    Node head;
    public deletemid(){
        this.head=null;
    }
    public void append(int data){
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
    public void printlist(){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public void removemid(){
        Node slow_ptr=head;
        Node fast_ptr = head;
        Node prev = null; 
        while(fast_ptr!=null || fast_ptr.next!=null){
        fast_ptr=fast_ptr.next.next;
        prev = slow_ptr;
        slow_ptr=slow_ptr.next;
    }
    System.out.println(+slow_ptr.data);
    prev.next = slow_ptr.next;
    slow_ptr=null;
    }
    public static void main(String[] args) {
        deletemid list = new deletemid();
        list.append(10);
        list.append(15);
        list.append(20);
        list.append(25);
        list.printlist();
        list.removemid();
        list.printlist();
    }
}