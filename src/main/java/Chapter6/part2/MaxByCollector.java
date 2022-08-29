package Chapter6.part2;

import Chapter4.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

public class MaxByCollector {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories); //Dish::getCalories or (dish) -> dish.getCalories()
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishComparator));

        Optional<Dish> lowestCalorieDish =
                menu.stream()
                        .collect(minBy(dishComparator));

        System.out.println(mostCalorieDish);
        System.out.println(lowestCalorieDish);

    }
}
