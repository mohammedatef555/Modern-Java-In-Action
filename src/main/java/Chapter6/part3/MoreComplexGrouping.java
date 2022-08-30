package Chapter6.part3;

import Chapter4.Dish;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class MoreComplexGrouping {
    public enum CaloricLevel {DIET, NORMAL, FAT}
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream().collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() >= 700) return CaloricLevel.FAT;
                    return CaloricLevel.NORMAL;
                }));
        System.out.println(dishesByCaloricLevel);
    }
}
