package Chapter5.part7;

import Chapter4.Dish;

import java.util.OptionalInt;

public class OptionalWithPrimtives {
    public static void main(String[] args) {
        OptionalInt max =
                Dish.menu.stream()
                        .mapToInt(Dish::getCalories)
                        .max();
        max.ifPresent(System.out::println);
    }
}
