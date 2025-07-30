package LinkedList;
import java.util.*;

class ListNode {
    int val ;
    ListNode next ;
    ListNode(int val){
        this.val = val ;
        this.next = null ;
    }
}

public class mergeKsortedList {
    public ListNode mergeKlists(ListNode[]lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        return dummyHead.next;
    }
    public static void main(String[] args) {
        
    }
}
