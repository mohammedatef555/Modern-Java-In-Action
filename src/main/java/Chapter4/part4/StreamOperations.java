package Chapter4.part4;

import Chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamOperations {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<String> names =
                menu.stream()// Gets a stream from the list of dishes
                        .filter(d -> d.getCalories() > 300) // Intermediate operation
                        .map(Dish::getName) // Intermediate operation
                        .limit(3) // Intermediate operation
                        .collect(toList()); // terminal operation
        // filter, map, and limit can be connected together to form a pipeline.
        // collect causes the pipeline to be executed and closes it.
        // Stream operations that can be connected are called intermediate operations,
        // and operations that close a stream are called terminal operations.
    }
}
