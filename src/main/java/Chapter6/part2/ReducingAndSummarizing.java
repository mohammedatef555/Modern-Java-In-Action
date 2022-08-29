package Chapter6.part2;

import Chapter4.Dish;

import static java.util.stream.Collectors.*;

public class ReducingAndSummarizing {
    public static void main(String[] args) {
        {
            // Collectors.counting()
            long howManyDishes = Dish.menu.stream().collect(counting());
            System.out.println(howManyDishes);
            // or write it like this
            howManyDishes = Dish.menu.stream().count();
            System.out.println(howManyDishes);
        }
    }
}
