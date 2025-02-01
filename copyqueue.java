import java.util.*;

class copyqueue{
    public static void main(String[] args) {
        Queue originalqueue = new ArrayDeque<>();
        Queue copyqueue = new ArrayDeque<>();
        originalqueue.add(10);
        originalqueue.add(20);
        originalqueue.add(30);
        originalqueue.add(40);

        for (Object object : originalqueue) { 
            copyqueue.add(originalqueue.remove());
        }
        System.out.println(copyqueue);

    }
}