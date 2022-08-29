package Chapter6.part1;

import Chapter4.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsInANutshell {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        // the argument passed to the collect method is an implementation of the Collector interface
        // Collectors utility class provides lots of static factory methods to conveniently create an
        // instance of the most common collectors that are ready to use. The most straightforward and
        // frequently used collector is the toList static method, which gathers all the elements
        // of a stream into a List:
        List<Dish> dishes =
                menu.stream().collect(Collectors.toList());

        System.out.println(menu);
        System.out.println(dishes);
        //collectors (the parameters to the stream method collect) are typically used in cases
        // where it’s necessary to reorganize the stream’s items into a collection. But more generally,
        // they can be used every time you want to combine all the items in the stream into a single result.
        // This result can be of any type, as complex as a multilevel map representing a tree or as simple
        // as a single integer, perhaps representing the sum of all the calories in the menu.
    }
}
