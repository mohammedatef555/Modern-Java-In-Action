package Chapter5.part1_Filtering;

import java.util.Arrays;
import java.util.List;

public class FilteringUniqueElements {
    public static void main(String[] args) {
        //Streams also support a method called distinct that returns a stream with unique elements
        // (according to the implementation of the hashcode and equals methods of the objects produced by the stream)
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .forEach(System.out::println);

    }
}
