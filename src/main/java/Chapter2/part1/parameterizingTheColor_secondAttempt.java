package Chapter2.part1;

import Chapter2.Apple;
import Chapter2.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class parameterizingTheColor_secondAttempt {
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (color.equals(apple.getColor())) {
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

        List<Apple> greenApples = filterApplesByColor(apples, Color.GREEN);
        List<Apple> redApples = filterApplesByColor(apples, Color.RED);

        Apple.printApples(greenApples);
        Apple.printApples(redApples);

        // But what if the farmer asks about filtering by weights
        // make another method the same as previous filtering methods ?!
        // but what if you have a bug in the method you will need to change all the filtering methods
        // maybe you should create a general filter - filtering with every attribute you can think of

    }
}
