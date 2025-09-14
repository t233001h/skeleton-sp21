package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    private static int testThree=3;
    public static void testThreeAddThreeRemove(){
      AListNoResizing<Integer> AList=new AListNoResizing<>();
        BuggyAList<Integer> BList=new BuggyAList<>();
        for (int i = 0; i < testThree; i++) {
            AList.addLast(i);
            BList.addLast(i+1);
        }
        assertEquals(AList.size(),BList.size());
        assertEquals(AList.removeLast(),BList.removeLast());
        assertEquals(AList.removeLast(),BList.removeLast());
    }

    public static void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> B = new BuggyAList<>();

      int N = 500000;
      /*for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        switch (operationNumber) {
          case 0:
            int randVal = StdRandom.uniform(0, 100);
            AList.addLast(randVal);
            BList.addLast(randVal);
            System.out.println("AList addLast(" + randVal + ")");
            System.out.println("BList addLast(" + randVal + ")");
            System.out.println();
            break;
          case 1:
            int sizeA = AList.size();
            int sizeB = BList.size();
            System.out.println("AList size: " + sizeA);
            System.out.println("BList size: " + sizeB);
            assertEquals(sizeA,sizeB);
            System.out.println();
            break;
          case 2:
            if(AList.size()==0){
              break;
            }
            int removeLastA = AList.removeLast();
            int removeLastB = BList.removeLast();
            System.out.println("AList removeLast:"+removeLastA);
            System.out.println("BList removeLast:"+removeLastB);
            assertEquals(removeLastA,removeLastB);
            System.out.println();
            break;
          case 3:
            if(AList.size()==0){
              break;
            }
            int getLastA = AList.getLast();
            int getLastB = BList.getLast();
            System.out.println("getLast:"+getLastA);
            System.out.println("getLast:"+getLastB);
            assertEquals(getLastA,getLastB);
            System.out.println();
            break;
        }*/
      for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        // addLast
        if (operationNumber == 0) {
          int randVal = StdRandom.uniform(0, 100);
          L.addLast(randVal);
          B.addLast(randVal);
          System.out.println("addLast(" + randVal + ")");
          // 1: size
        } else if (operationNumber == 1) {
          int size = L.size();
          int size1 = B.size();
          System.out.println("size: " + size);
          assertEquals(size, size1);
          // 2: getLast
        } else if (L.size() > 0 && operationNumber == 2) {
          int res = L.getLast();
          int res1 = B.getLast();
          System.out.println("getLast: " + res);
          assertEquals(res, res1);
          // 3: removeLast
        } else if (L.size() > 0 && operationNumber == 3) {
          int res = L.removeLast();
          int res1 = B.removeLast();
          System.out.println("removeLast: " + res);
          assertEquals(res, res1);
        }
      }


        /*if (operationNumber == 0) {
          // addLast
          int randVal = StdRandom.uniform(0, 100);
          L.addLast(randVal);
          System.out.println("addLast(" + randVal + ")");
        } else if (operationNumber == 1) {
          // size
          int size = L.size();
          System.out.println("size: " + size);
        }*/

    }

    public static void main(String[] args) {

        randomizedTest();
    }


}
