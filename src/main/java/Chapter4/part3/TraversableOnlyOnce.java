package Chapter4.part3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TraversableOnlyOnce {
    public static void main(String[] args) {
        // Similarly to iterators, a stream can be traversed only once. After that a stream is said to be consumed.
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        try{
            s.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // stream has already been operated upon or closed
        }
    }
}
