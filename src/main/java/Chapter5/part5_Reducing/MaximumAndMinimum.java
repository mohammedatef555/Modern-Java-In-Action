package Chapter5.part5_Reducing;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaximumAndMinimum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        {
            // Maximum
            Optional<Integer> max = numbers.stream()
                    .reduce((a, b) -> a > b ? a : b);
            System.out.println(max);
            max = numbers.stream().reduce(Integer::max);
            System.out.println(max);
        }
        {
            // Minimum
            Optional<Integer> min =
                    numbers.stream()
                            .reduce((a,b) -> a < b ? a : b );
            System.out.println(min);
            min = numbers.stream().reduce(Integer::min);
            System.out.println(min);

        }

    }
}
