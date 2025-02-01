class linkedlist{
    Node head;
    private int size;
    linkedlist(){
  this.size = 0;
    }
    class Node{
        int data;
        Node next;
      Node (int data){
        this.data =data;
        this.next =null;
        size++;
      }
    }
    public void addfirst(int data){
        Node newNode = new Node( data);
if(head==null){
head=newNode;
return;
}
newNode.next=head;
head=newNode;
    }
    public void addlast(int data){
             Node newNode = new Node(data);
if(head==null){
head=newNode;
return;
}
Node currNode =head;
while(currNode.next != null){
    currNode=currNode.next;
}
    currNode.next = newNode;
    }
    public void deletefirst(){
        if(head==null){
           System.out.println("list is empty:");
           return;
        }     
        size--;
        head = head.next;    
    }
    public void deletelast(){
        if(head==null){
            System.out.println("the list is empty:");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node secondlast=head;
        Node lastNode = head.next;
        while(lastNode.next !=null){
            lastNode =lastNode.next;
            secondlast = secondlast.next;
        }
        secondlast.next=null;
    }
    public void printlist(){
        if(head==null){
            System.out.println("empty:");
            return;
        }
        Node currNode =head;
while(currNode != null){
    System.out.println(currNode.data +"->");
    currNode=currNode.next;
}
   //   System.out.println("null");
    }
    public int getsize(){
        return size;
    }
    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.addfirst(25);
        list.addfirst(10);
      list.addlast(30);
      list.addlast(35);
      list.printlist();
      System.out.println();
      list.deletefirst();
      list.deletelast();
      list.printlist();
      System.out.println(list.getsize() );
    }
}