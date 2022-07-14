package Chapter2.part1;

import Chapter2.Apple;
import Chapter2.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class filterWithEveryAttr_thirdAttempt {
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if ((flag && color.equals(apple.getColor())) ||
                !flag && apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(1, Color.GREEN, 200),
                new Apple(2, Color.RED, 160),
                new Apple(3, Color.GREEN, 100),
                new Apple(4, Color.RED, 120),
                new Apple(5, Color.GREEN, 155));

        List<Apple> greenApples = filterApples(apples, Color.GREEN, 0, true);
        List<Apple> heavyApples = filterApples(apples, null, 150, false);

        Apple.printApples(greenApples);
        System.out.println("###################");
        Apple.printApples(heavyApples);

       // This solution is extremely bad. First, the client code looks terrible. What do true and false mean? In addition, this solution doesn’t cope well
        // with changing requirements. What if the farmer asks you to filter with different attributes of an apple,
        // for example, its size, its shape, its origin, and so on? Furthermore,
        // what if the farmer asks you for more complicated queries that combine attributes,
        // such as green apples that are also heavy? You’d either have multiple duplicated filter methods
        // or one hugely complex method. So far, you’ve parameterized the filterApples method with values
        // such as a String, an Integer, an enum type, or a boolean. This can be fine for certain well-defined problems.
        // But in this case, what you need is a better way to tell your filterApples method the selection criteria for apples.
        // In the next section, we describe how to make use of behavior parameterization to attain that flexibility.
    }
}
