import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int h = 1024 * 1024 * 1024 + 1;
        System.out.println(h);
        System.out.println(h >>> 16);
        System.out.println((h) ^ (h >>> 16));

        System.out.println(Integer.MAX_VALUE << 1);

        HashMap m = new HashMap();

        HashMap m1 = new HashMap(32);

        Queue queue = new LinkedList();
        Stack stack = new Stack();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

}
