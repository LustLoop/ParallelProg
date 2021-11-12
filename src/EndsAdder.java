import java.util.concurrent.TimeUnit;

public class EndsAdder implements Runnable {

    private final int[] numArray;
    private final int indexStart;
    private final int indexEnd;

    public EndsAdder(int[] numArray, int indexStart, int indexEnd) {
        this.numArray = numArray;
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    @Override
    public void run() {
//        Uncomment to visualize work process

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(numArray[indexStart] + " + " + numArray[indexEnd - indexStart - 1]);

        numArray[indexStart] += numArray[indexEnd - indexStart - 1];
    }
}
