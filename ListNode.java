import java.util.LinkedList;

class Node{
int data;
Node next;
public Node(int data){
    this.data = data;
    this.next = null;
}
}
class ListNode{
    Node head;
    public ListNode(){
        this.head = null;
    }
    public void append(int data){
        Node new_node= new Node(data);
        if(head == null){
      head = new_node;
      return;
    }
    Node last = head;
    while (last.next != null) {
      last = last.next;
    }
    last.next = new_node;
  }

  // Print the list
  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  // Find and return the middle element of the list
  public int findMiddle() {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.data;
  }
 public static void main (String [] args){
    ListNode list = new ListNode();
    list.append(10);
    list.append(15);
    list.append(20);
    list.append(25);
    list.append(30);
    list.printList();
    list.findMiddle();
    System.out.println(+list.findMiddle());
    }
}