import java.util.*;
public class sumofNodes2{
static class Node {
    int data;
    Node left ,right;


    Node(int data){
        this.data = data;  
        this.left = null;
        this.right = null;
    }
}
public static int sumofNodes(Node root,int k){
    if(root==null){
        return 0;
    }
    Queue <Node> queue =new LinkedList<>();
    //adding elements in the queue
    queue.add(root);
    //initializing the current level with the zero
    int currentLevel = 0 ;
    //initializing the levelsum with the zero
    int levelsum =0;
    while(!queue.isEmpty()){
        int size = queue.size();
        levelsum = 0 ;
        for(int i=0;i<size;i++){
            Node temp = queue.poll();
            if(currentLevel ==k){
                levelsum += temp.data;
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }

        }
        currentLevel++;

        if(currentLevel>k){
            break;
        }
    }
    return levelsum;
}
public static void main(String[] args) {
    int k=1;
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    System.out.println(sumofNodes(root,k));
}
}