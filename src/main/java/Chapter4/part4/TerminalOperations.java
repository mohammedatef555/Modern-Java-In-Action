package Chapter4.part4;

import Chapter4.Dish;

import java.util.List;

public class TerminalOperations {
    public static void main(String[] args) {
        //Terminal operations produce a result from a stream pipeline.
        // A result is any non-stream value such as a List, an Integer, or even void. For example,
        // in the following pipeline, forEach is a terminal operation that returns void and applies
        // a lambda to each dish in the source. Passing System.out.println to forEach asks it
        // to print every Dish in the stream created from menu:
        Dish.menu.stream().forEach(System.out::println);
    }
}
