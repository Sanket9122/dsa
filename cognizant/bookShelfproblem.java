package cognizant;
import java.util.*;
public class bookShelfproblem {
    public int bokkShelf(int shelfcapacity , int [] books , int students){
        int n = books.length ;
        if(students != n)  return -1;
        int carry = 0;
        int count =0;
        for(int i=0;i<n ;i++){
            int book = books[i];
            int total_books = carry+book;
            int desckshelves = total_books / shelfcapacity;
            count+= desckshelves;
            carry = total_books % shelfcapacity;
        }
        return count;
            
    }
    public static void main(String[] args) {
        bookShelfproblem bsp = new bookShelfproblem();
        int [] books = {5,6,4};
        int shelfcapacity = 7;
        int students = 3;
        System.out.println(bsp.bokkShelf(shelfcapacity, books, students));
    }
}
