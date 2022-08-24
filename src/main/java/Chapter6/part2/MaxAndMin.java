package Chapter6.part2;

import Chapter4.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

public class MaxAndMin {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        Comparator<Dish> dishCaloriesComparator =  Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(maxCalorieDish);

        Optional<Dish> minCalorieDish = menu.stream().collect(minBy(dishCaloriesComparator));
        System.out.println(minCalorieDish);

    }
}
