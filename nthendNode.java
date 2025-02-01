import java.util.*;
public class nthendNode{
    public static nthendNode.node nthNode(node head,int n){
        int size=0;
        node temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int m = size-n+1;
        temp=head;
        for(int i=1;i<m;i++){
            temp=temp.next;
        }
        return temp;
    }
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
node a=new node(25);
node b=new node(20);
node c=new node(15);
node d=new node(10);
node e=new node(5);
a.next=b;
b.next=c;
c.next=d;
d.next=e;
e.next=null;
node q=nthNode(a,1);
System.out.println(q.data);
    }

}

