package Chapter5.part3_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatteningStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "world");
        List<String> l = words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(l); // [H, e, l, o, w, r, d]
    }
}
