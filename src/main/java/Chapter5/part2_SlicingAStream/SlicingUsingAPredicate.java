package Chapter5.part2_SlicingAStream;

import Chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SlicingUsingAPredicate {
    public static void main(String[] args) {
        // it is sorted with the number of calories
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        {
            // using filter
            List<String> names =
                    specialMenu.stream()
                            .filter(d -> d.getCalories() < 320)
                            .map(Dish::getName)
                            .collect(Collectors.toList());
            System.out.println(names);
        }
        {
            // using take while
            // lets you slice any stream (even an infinite stream as you will learn later)
            // using a predicate. But thankfully, it stops once it has found an element that fails to match.
            List<String> names =
                    specialMenu.stream()
                            .takeWhile(d -> d.getCalories() < 320)
                            .map(Dish::getName)
                            .collect(Collectors.toList());
            System.out.println(names);
        }
        {
            // using drop while
            // The dropWhile operation is the complement of takeWhile. It throws away the
            // elements at the start where the predicate is false. Once the predicate evaluates to
            // true it stops and returns all the remaining elements, and it even works if there are an
            // infinite number of remaining elements!
            List<String> names =
                    specialMenu.stream()
                            .dropWhile(d -> d.getCalories() < 320)
                            .map(Dish::getName)
                            .collect(Collectors.toList());
            System.out.println(names);
        }
    }
}
