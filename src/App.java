import java.util.stream.IntStream;

public class App {
    public static int[] numArray = IntStream.range(1, 10).toArray();
    public static boolean isOdd = numArray.length % 2 == 1;
    public static int currentElementsCount = numArray.length;
    public static int iterationsCount = numArray.length / 2;

    public static void main(String[] args) {

        SumGetter sumGetter = new SumGetter();

        sumGetter.getWaveSum(numArray, iterationsCount, currentElementsCount, isOdd);

        System.out.println(numArray[0]);
    }
}
