package Chapter2.part2;

import Chapter2.Apple;
import Chapter2.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class behaviorParameterization {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrint formatter) {
        for (Apple apple: inventory){
            formatter.print(apple);
        }
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(1, Color.GREEN, 200),
                new Apple(2, Color.RED, 160),
                new Apple(3, Color.GREEN, 100),
                new Apple(4, Color.RED, 120),
                new Apple(5, Color.GREEN, 155));

        List<Apple> greenApples = filterApples(apples, new AppleGreenColorPredicate());
        List<Apple> redAndHeavyApples = filterApples(apples, new AppleRedAndHeavyPredicate());
        Apple.printApples(greenApples);
        System.out.println("############");
        Apple.printApples(redAndHeavyApples);

        System.out.println("############");
        System.out.println("############");
        prettyPrintApple(apples, new ApplePrintWeightOnly());
        prettyPrintApple(apples, new ApplePrintAllDetails());

    }
}
