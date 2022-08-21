package Chapter5.part2_SlicingAStream;

import Chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class SkippingElements {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<Dish> dishes =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(Collectors.toList());
        System.out.println(dishes);
    }
}
