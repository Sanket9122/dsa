import java.util.*;

class Node {
    int data;
    Node head;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class rotatelist {
    Node head;

    public rotatelist() {
        this.head = null;
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

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void rotateclockwise(int k) {
        if (head == null) {
            return;
        }
        Node last = head;
        int len = 1;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        if (k < len) {
            k = k % len;
            k = len - k;
            if (k == 0 || k == len)
                return;
            Node current = head;
            int count = 1;
            while (count < k || current != null) {
                current = current.next;
                count++;
            }
            if (current == null)
                return;
            Node kNode = current;
            last.next = head;
            head = kNode.next;
            kNode.next = null;
        }
    }

    public static void main(String[] args) {
        rotatelist list = new rotatelist();
        list.append(10);
        list.append(15);
        list.append(20);
        list.append(25);
        list.append(30);
        list.printList();
        list.rotateclockwise(1);
        list.printList();
    }
}
