package Chapter5.part7;

import Chapter4.Dish;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertingBackToAStreamOfObjects {
    public static void main(String[] args) {
        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    }
}
