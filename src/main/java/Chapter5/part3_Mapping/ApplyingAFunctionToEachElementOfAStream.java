package Chapter5.part3_Mapping;

import Chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApplyingAFunctionToEachElementOfAStream {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        {
            List<String> names =
                    menu.stream()
                            .map(Dish::getName)
                            .collect(Collectors.toList());
            System.out.println(names);
        }
        {
            List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
            List<Integer> wordLengths =
                    words.stream()
                            .map(String::length)
                            .collect(Collectors.toList());
            System.out.println(wordLengths);
        }
        {
            List<Integer> dishNameLengths =
                    menu.stream()
                            .map(Dish::getName)
                            .map(String::length)
                            .collect(Collectors.toList());
            System.out.println(dishNameLengths);
        }
    }
}
