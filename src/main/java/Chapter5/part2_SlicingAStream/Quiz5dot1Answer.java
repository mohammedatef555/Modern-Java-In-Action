package Chapter5.part2_SlicingAStream;

import Chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class Quiz5dot1Answer {
    public static void main(String[] args) {
        // How would you use streams to filter the first two meat dishes?
        List<Dish> menu = Dish.menu;
        List<Dish> meatDishes =
                menu.stream()
                        .filter( d -> d.getType() == Dish.Type.MEAT)
                        .limit(2)
                        .collect(Collectors.toList());
        System.out.println(meatDishes);
    }
}
