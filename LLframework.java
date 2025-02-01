import java.util.*;

class LLframework{
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.addFirst(15);
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("null");
    }
}