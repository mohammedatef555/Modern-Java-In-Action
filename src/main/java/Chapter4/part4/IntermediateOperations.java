package Chapter4.part4;

import Chapter4.Dish;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class IntermediateOperations {
    public static void main(String[] args) {
        // Intermediate operations such as filter or sorted return another stream as the return type.
        // This allows the operations to be connected to form a query. What’s important is that
        // intermediate operations don’t perform any processing until a terminal operation is invoked
        // on the stream pipeline—they’re lazy. This is because intermediate operations can usually
        // be merged and processed into a single pass by the terminal operation.
        List<String> names =
                Dish.menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering:" + dish.getName());
                            return dish.getCalories() > 300;
                        })
                .map(dish -> {
                    System.out.println("mapping:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        //By doing this, you can notice that the Streams library performs several optimizations exploiting
        // the lazy nature of streams. First, despite the fact that many dishes have more than 300 calories,
        // only the first three are selected! This is because of the limit operation and a technique called short-circuiting,
        // Second, despite the fact that filter and map are two separate operations,
        // they were merged into the same pass (compiler experts call this technique loop fusion).
        System.out.println(names);
    }
}
