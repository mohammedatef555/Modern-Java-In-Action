package Chapter6.part3;

import Chapter4.Dish;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class SimpleGrouping {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }
}
