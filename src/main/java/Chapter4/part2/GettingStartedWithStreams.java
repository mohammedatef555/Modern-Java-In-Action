package Chapter4.part2;

import Chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class GettingStartedWithStreams {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<String> threeHighCaloricDishNames =
                menu.stream() //Gets a stream from menu (the list of dishes)
                        .filter(d -> d.getCalories() > 300) //Creates a pipeline of operations: first filter high-calorie dishes
                        .map(Dish::getName) // Gets the names of the dishes
                        .limit(3) // Selects only the first three
                        .collect(toList()); // or .toList() directly // Stores the results in another List
        //No result is produced, and indeed no element from menu is even selected,
        // until collect is invoked. You can think of it as if the method invocations in the chain
        // are queued up until collect is called.

        System.out.println(threeHighCaloricDishNames);
    }
}
