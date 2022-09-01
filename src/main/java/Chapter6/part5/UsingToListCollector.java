package Chapter6.part5;

import Chapter4.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsingToListCollector {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        List<Dish> sameMenu =
                menu.stream()
                        .collect(new ToListCollector<>());
        List<Dish> alsoTheSameMenu =
                menu.stream().collect(Collectors.toList());
        System.out.println(menu); // The original List
        System.out.println(sameMenu); // The List produced by using our own customizable collector
        System.out.println(alsoTheSameMenu); // The List produced by using predefined collector
        {
            // Performing a custom collect without creating a Collector implementation
            List<Dish> dishes =
                    menu.stream()
                            .collect(ArrayList::new,
                                    List::add,
                                    List::addAll);
            System.out.println(dishes);
        }
    }
}
