package Chapter6.part2;

import Chapter4.Dish;

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Summarization {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        int totalCalories = menu.stream().collect(summingInt(dish -> dish.getCalories()));
        System.out.println(totalCalories);
        totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        {
            // Average
            double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
            System.out.println(avgCalories);
        }
        {
            //Summarization and Statistics
            IntSummaryStatistics statistics = menu.stream().collect(summarizingInt(Dish::getCalories));
            System.out.println(statistics);
        }
    }
}
