package Chapter5.part7;

import Chapter4.Dish;

import java.util.List;

public class MappingToANumericStream {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        int calories =
                menu.stream()
                        .mapToInt(Dish::getCalories)
                        .sum();
        System.out.println(calories);
    }
}
