package Chapter2.part3;

import Chapter2.Apple;
import Chapter2.Color;
import Chapter2.part2.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class usingAnonymousClassesAndLambda {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple: inventory) {
            if (p.test(apple)){
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

        List<Apple> redApples = filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        Apple.printApples(redApples);

        List <Apple> result = filterApples(apples, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println("Lambda Magic");
        Apple.printApples(redApples);
    }


}
