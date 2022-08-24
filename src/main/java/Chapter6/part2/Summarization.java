package Chapter6.part2;

import Chapter4.Dish;

import static java.util.stream.Collectors.*;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Summarization {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        totalCalories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(totalCalories);
        double avgCalories = menu.stream().collect(averagingDouble(Dish::getCalories));
        System.out.println(avgCalories);
        DoubleSummaryStatistics doubleSummaryStatistics = menu.stream().collect(summarizingDouble(Dish::getCalories));
        System.out.println(doubleSummaryStatistics);
    }
}
