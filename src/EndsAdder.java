import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class EndsAdder implements Runnable {

    private final CyclicBarrier barrier;
    private final int[] numArray;
    private final int indexStart;
    private final int indexEnd;

    public EndsAdder(CyclicBarrier barrier, int[] numArray, int indexStart, int indexEnd) {
        this.barrier = barrier;
        this.numArray = numArray;
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(numArray[indexStart] + " + " + numArray[indexEnd - indexStart - 1]);

        numArray[indexStart] += numArray[indexEnd - indexStart - 1];

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
