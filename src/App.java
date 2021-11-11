import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int[] numArray = IntStream.range(1, 11).toArray();

        boolean isOdd = numArray.length % 2 == 1;
        int currentElementsCount = numArray.length;
        int iterationsCount = numArray.length / 2;

        while (currentElementsCount != 1) {
            for (int i = 0; i < iterationsCount; i++) {
                numArray[i] += numArray[currentElementsCount - i - 1];
            }

            currentElementsCount = iterationsCount;
            if (isOdd) {
                currentElementsCount++;
            }
            iterationsCount = currentElementsCount / 2;
            isOdd = currentElementsCount % 2 == 1;
        }

        System.out.println(numArray[0]);
    }
}
