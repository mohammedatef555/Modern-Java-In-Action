package Chapter5.part4_FindingAndMatching;

import Chapter4.Dish;

import java.util.List;

public class FindingAndMatching {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        {
            // 5.4.1. Checking to see if a predicate matches at least one element
            if(menu.stream().anyMatch(d -> d.isVegetarian())){
                System.out.println("The menu is (somewhat) vegetarian friendly!!");
            }
        }
        {
            // 5.4.2. Checking to see if a predicate matches all elements
            boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
            System.out.println(isHealthy);
        }
        {
            // none match
            boolean isHealthy = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
            System.out.println(isHealthy);
        }
    }
}
