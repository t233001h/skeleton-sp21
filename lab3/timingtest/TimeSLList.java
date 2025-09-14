package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }
    private static int cnt=10000;
    private static int m=100000;

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns=new AList<>();
        AList<Double> times=new AList<>();
        AList<Integer> opCounts=new AList<>();
        for (int i = cnt; i <=cnt*10 ; i+=cnt) {
            getItem(Ns, times, opCounts, i);
        }
        printTimingTable(Ns, times, opCounts);
    }
    public static void getItem(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int n) {
        SLList<Integer> testList=new SLList<>();
        for (int i = 0; i < n; i++) {
            testList.addFirst(i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i=0;i<m;i++){
            testList.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(n);
        times.addLast(timeInSeconds);
        opCounts.addLast(m);
    }

}
