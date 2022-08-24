package Chapter6.part2;

import Chapter4.Dish;

import java.util.List;
import static java.util.stream.Collectors.*;

public class JoiningStrings {
    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        String shortMenu = menu.stream().map(Dish::toString).collect(joining(", "));
        System.out.println(shortMenu);
    }
}
