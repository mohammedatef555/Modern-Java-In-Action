package Chapter5.part5_Reducing;

import Chapter4.Dish;

import java.util.List;
import java.util.Optional;

public class Quiz5dot3Answer {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        Integer count =
                menu.stream()
                        .map(d -> 1)
                        .reduce(0, Integer::sum);
        System.out.println("count = " + count + "\nmenu.size = " + menu.size());
        long numberOfDishes = menu.stream().count();
        System.out.println(numberOfDishes);
    }
}
