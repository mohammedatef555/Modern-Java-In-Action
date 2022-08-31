package Chapter6.part4;

import Chapter4.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class Partitioning {
    public static void main(String[] args) {
        //Partitioning is a special case of grouping: having a predicate called a partitioning
        // function as a classification function. The fact that the partitioning function returns
        // a boolean means the resulting grouping Map will have a Boolean as a key type, and therefore,
        // there can be at most two different groups—one for true and one for false
        List<Dish> menu = Dish.menu;
        {
            Map<Boolean, List<Dish>> partitionedMenu =
                    menu.stream().collect(partitioningBy(Dish::isVegetarian));
            System.out.println(partitionedMenu);
            List<Dish> vegetarianDishes = partitionedMenu.get(true);
            System.out.println(vegetarianDishes);
        }
        {
            Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                    menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
            System.out.println(vegetarianDishesByType);
        }
    }
}
