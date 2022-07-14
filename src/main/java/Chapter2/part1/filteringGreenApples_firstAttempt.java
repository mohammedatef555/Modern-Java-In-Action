package Chapter2.part1;

import Chapter2.Apple;
import Chapter2.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class filteringGreenApples_firstAttempt {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(1, Color.GREEN),
                new Apple(2, Color.RED),
                new Apple(3, Color.GREEN),
                new Apple(4, Color.RED),
                new Apple(5, Color.GREEN));

        List<Apple> greenApples = filterGreenApples(apples);
        Apple.printApples(greenApples);
        // but the requirements always change, what to do if we need to filter the red apples
        // should we write a method filterRedApples that same as filterGreenApples with only minor change that will work
        // But it's not the best solution let's try parameterizing the color
    }
}
