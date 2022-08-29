package Chapter6.part2;

import Chapter4.Dish;

import java.util.List;
import static java.util.stream.Collectors.*;

public class CountingCollectorUsingGeneralReducing {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        int count = menu.stream().collect(reducing(0, e -> 1, (a, b) -> a + b ));
        System.out.println(count);
    }
}
