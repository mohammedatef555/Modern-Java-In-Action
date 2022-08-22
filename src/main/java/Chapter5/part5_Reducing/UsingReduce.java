package Chapter5.part5_Reducing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UsingReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3);
        int sum =
                numbers.stream()
                        .reduce(0, (a,b) -> a+b);
        System.out.println(sum); // 6

        Optional<Integer> sumInteger = numbers.stream().reduce(Integer::sum);
        sumInteger.ifPresent(System.out::println); // 6
    }
}
