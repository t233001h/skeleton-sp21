package deque;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyArrayListDequeTest {
    private static final int TestTime = 500000;

    public static void test() {
        MyArrayDeque<Integer> MyList = new MyArrayDeque<>();
        Deque<Integer> List = new ArrayDeque<>();
        for (int i = 0; i < TestTime; i += 1) {
            System.out.println("测试"+i);
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0:
                    int randFirstVal = StdRandom.uniform(0, 100);
                    MyList.addFirst(randFirstVal);
                    List.addFirst(randFirstVal);
                    System.out.println("AList addFirst(" + randFirstVal + ")");
                    System.out.println("BList addFirst(" + randFirstVal + ")");
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
                    int getFirstA = MyList.getLast();
                    int getFirstB = List.getLast();
                    System.out.println("getFirstA:" + getFirstA);
                    System.out.println("getFirstB:" + getFirstB);
                    assertEquals(getFirstA, getFirstB);
                    System.out.println();
                    break;
                case 3:
                    if (MyList.isEmpty()) {
                        break;
                    }
                    int getLastA = MyList.getLast();
                    int getLastB = List.getLast();
                    System.out.println("getLast:" + getLastA);
                    System.out.println("getLast:" + getLastB);
                    assertEquals(getLastA, getLastB);
                    System.out.println();
                    break;

                case 4:
                    int randLastVal = StdRandom.uniform(0, 100);
                    MyList.addLast(randLastVal);
                    List.addLast(randLastVal);
                    System.out.println("AList addLast(" + randLastVal + ")");
                    System.out.println("BList addLast(" + randLastVal + ")");
                    System.out.println();
                    break;

                case 5:
                    if (MyList.isEmpty()) {
                        break;
                    }
                    int index = StdRandom.uniform(0, MyList.size());
                    int getA = MyList.get(index);
                    System.out.println("getLast:" + getA);
                    System.out.println();
                    break;
            }

        }

    }

    public static void main(String[] args) {
        test();
    }



}

