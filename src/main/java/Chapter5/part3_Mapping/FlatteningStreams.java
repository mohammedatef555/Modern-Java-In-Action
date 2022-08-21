package Chapter5.part3_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatteningStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "world");
//        String[] arr = {"Hello", "world"};
//        Stream<String> stringStream = Arrays.stream(arr);
//        stringStream.forEach(System.out::println);
//        words.stream()
//                .map(word -> word.split(""))
//                .map(Arrays::stream)
//                .forEach(System.out::println);
        // Stream<String>
        // Stream<String[]>
        // Stream<Stream<String>>
        words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::print);
    }
}
