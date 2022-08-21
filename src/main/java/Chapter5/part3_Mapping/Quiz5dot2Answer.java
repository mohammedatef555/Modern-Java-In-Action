package Chapter5.part3_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz5dot2Answer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5);
        List<Integer> squareNumbers =
                numbers.stream()
                        .map(number -> number * number)
                        .collect(Collectors.toList());
        System.out.println(squareNumbers);
    }
}
