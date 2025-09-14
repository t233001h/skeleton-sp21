package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }
    private static int thousand=1000;
    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns=new AList<>();
        AList<Double> times=new AList<>();
        AList<Integer> opCounts=new AList<>();
        for (int i = 10000; i <=thousand*1000 ; i+=thousand*100) {
            additem(Ns, times, opCounts, i);
        }
        printTimingTable(Ns, times, opCounts);

    }

    public static void additem(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts,int n){
        Stopwatch sw = new Stopwatch();
        AList<Integer> testList=new AList<>();;
        for (int i = 0; i < n; i++) {
            testList.addLast(i);
        }
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(n);
        times.addLast(timeInSeconds);
        opCounts.addLast(n);
    }
}
