package Chapter6.part2;

import Chapter4.Dish;

import java.util.List;
import static java.util.stream.Collectors.*;

public class GeneralizedSummarizationWithReduction {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i,j) -> i + j));
        System.out.println(totalCalories);
    }
}
