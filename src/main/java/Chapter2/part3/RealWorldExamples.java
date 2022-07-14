package Chapter2.part3;

import Chapter2.Apple;
import Chapter2.Color;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RealWorldExamples {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(1, Color.GREEN, 200),
                new Apple(2, Color.RED, 160),
                new Apple(3, Color.GREEN, 100),
                new Apple(4, Color.RED, 120),
                new Apple(5, Color.GREEN, 155));

        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });

        Apple.printApples(apples);
    }
}
