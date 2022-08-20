package Chapter4.part3;

import Chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InternalIteration {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<String> names =
                // library takes care of iterating for you
                menu.stream()
                        .map(Dish::getName)
                        .collect(toList());
        System.out.println(names);
    }
}
