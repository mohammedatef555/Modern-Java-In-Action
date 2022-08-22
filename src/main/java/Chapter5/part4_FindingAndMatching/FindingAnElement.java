package Chapter5.part4_FindingAndMatching;

import Chapter4.Dish;

import java.util.List;
import java.util.Optional;

public class FindingAnElement {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        Optional<Dish> dish =
                menu.stream()
                        .filter(d -> d.isVegetarian())
                        .findAny();

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);

    }
}
