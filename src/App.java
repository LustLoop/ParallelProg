import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class App {
    public static int[] numArray = IntStream.range(1, 11).toArray();
    public static boolean isOdd = numArray.length % 2 == 1;
    public static int currentElementsCount = numArray.length;
    public static int iterationsCount = numArray.length / 2;

    public static void main(String[] args) {

        summarizeWave(Executors.newFixedThreadPool(iterationsCount));

        System.out.println(numArray[0]);
    }

    public static void summarizeWave(ExecutorService executorService) {
        for (int i = 0; i < iterationsCount; i++) {
            executorService.execute(new EndsAdder(numArray, i, currentElementsCount));
        }

        currentElementsCount = iterationsCount;
        if (isOdd) {
            currentElementsCount++;
        }
        iterationsCount = currentElementsCount / 2;
        isOdd = currentElementsCount % 2 == 1;

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                if (currentElementsCount != 1) {
                    summarizeWave(Executors.newFixedThreadPool(iterationsCount));
                }
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
