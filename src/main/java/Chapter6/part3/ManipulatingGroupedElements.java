package Chapter6.part3;

import Chapter4.Dish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;


public class ManipulatingGroupedElements {
    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                Dish.menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(caloricDishesByType);


        {
            Map<Dish.Type, List<String>> dishNamesByType =
                    Dish.menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName,toList())));
            System.out.println(dishNamesByType);
        }
        {
            Map<String, List<String>> dishTags = new HashMap<>();
            dishTags.put("pork", asList("greasy", "salty"));
            dishTags.put("beef", asList("salty", "roasted"));
            dishTags.put("chicken", asList("fried", "crisp"));
            dishTags.put("french fries", asList("greasy", "fried"));
            dishTags.put("rice", asList("light", "natural"));
            dishTags.put("season fruit", asList("fresh", "natural"));
            dishTags.put("pizza", asList("tasty", "salty"));
            dishTags.put("prawns", asList("tasty", "roasted"));
            dishTags.put("salmon", asList("delicious", "fresh"));
            Map<Dish.Type, Set<String>> dishNamesByType =
                    Dish.menu.stream()
                            .collect(groupingBy(Dish::getType,
                                    flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
                                            toSet())));
            System.out.println(dishNamesByType);
        }
    }
}
