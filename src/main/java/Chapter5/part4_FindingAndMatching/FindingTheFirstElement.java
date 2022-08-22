package Chapter5.part4_FindingAndMatching;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingTheFirstElement {
    public static void main(String[] args) {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        someNumbers.stream()
                .map(n -> n*n)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println);

    }
}
