package Chapter5.part1_Filtering;

import Chapter4.Dish;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FilteringWithAPredicate {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<Dish> vegetarianMenu =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());
        System.out.println(vegetarianMenu);
    }
}
