import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SumGetter {

    public synchronized void getWaveSum(int[] numArray, int iterationsCount, int currentElementsCount, boolean isOdd) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(iterationsCount + 1);

        for (int i = 0; i < iterationsCount; i++) {
            EndsAdder adder = new EndsAdder(cyclicBarrier, numArray, i, currentElementsCount);
            new Thread(adder).start();
        }

        currentElementsCount = iterationsCount;
        if (isOdd) {
            currentElementsCount++;
        }
        iterationsCount = currentElementsCount / 2;
        isOdd = currentElementsCount % 2 == 1;

        try {
            cyclicBarrier.await();
            if (currentElementsCount != 1) {
                getWaveSum(numArray, iterationsCount, currentElementsCount, isOdd);
            } else {
                System.out.println("done");
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
