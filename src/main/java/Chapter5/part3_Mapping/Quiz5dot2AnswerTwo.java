package Chapter5.part3_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz5dot2AnswerTwo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<Integer> nums1 = Arrays.asList(3, 4);

        List<int[]> pairs =
                nums.stream()
                        .flatMap(i -> nums1.stream()
                                .map(j -> new int[] {i,j}))
                                .collect(Collectors.toList());

//                        .collect(Collectors.toList());
        System.out.println(pairs);
    }
}
