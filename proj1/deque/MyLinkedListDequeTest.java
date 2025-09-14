package deque;

import java.util.LinkedList;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyLinkedListDequeTest {
    private static final int TestTime = 500;

    public static void test() {
        LinkedListDeque<Integer> MyList = new LinkedListDeque<>();
        LinkedList<Integer> List = new LinkedList<>();

        for (int i = 0; i < TestTime; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0:
                    int randVal = StdRandom.uniform(0, 100);
                    MyList.addFirst(randVal);
                    List.addFirst(randVal);
                    System.out.println("AList addLast(" + randVal + ")");
                    System.out.println("BList addLast(" + randVal + ")");
                    System.out.println();
                    break;
                case 1:
                    int sizeA = MyList.size();
                    int sizeB = List.size();
                    System.out.println("AList size: " + sizeA);
                    System.out.println("BList size: " + sizeB);
                    assertEquals(sizeA, sizeB);
                    System.out.println();
                    break;
                case 2:
                    if (MyList.isEmpty()) {
                        break;
                    }
                    int removeLastA = MyList.removeLast();
                    int removeLastB = List.removeLast();
                    System.out.println("AList removeLast:" + removeLastA);
                    System.out.println("BList removeLast:" + removeLastB);
                    assertEquals(removeLastA, removeLastB);
                    System.out.println();
                    break;
                case 3:
                    if (MyList.isEmpty()) {
                        break;
                    }
                    int index = StdRandom.uniform(0, MyList.size());
                    int getLastA = MyList.get(index);
                    int getLastB = List.get(index);
                    System.out.println("getLast:" + getLastA);
                    System.out.println("getLast:" + getLastB);
                    assertEquals(getLastA, getLastB);
                    System.out.println();
                    break;
            }
        }

    }

    public static void main(String[] args) {
        test();
    }
}