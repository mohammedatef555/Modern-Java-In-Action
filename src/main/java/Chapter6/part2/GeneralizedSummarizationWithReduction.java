package Chapter6.part2;

import Chapter4.Dish;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class GeneralizedSummarizationWithReduction {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        {
            int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));
            System.out.println(totalCalories);
        }
        {
            // highest-calorie dish
            Optional<Dish> mostCalorieDish =
                    menu.stream().collect(reducing( (a, b) -> a.getCalories() > b.getCalories() ? a : b ));

            System.out.println(mostCalorieDish);
        }
    }
}
