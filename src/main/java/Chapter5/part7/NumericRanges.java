package Chapter5.part7;

import java.util.stream.IntStream;

public class NumericRanges {
    public static void main(String[] args) {
        IntStream evenNumbers =
                IntStream.rangeClosed(1, 100)
                        .filter(i -> i % 2 == 0);
        System.out.println(evenNumbers.count());
    }
}
