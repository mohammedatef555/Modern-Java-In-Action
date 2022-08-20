package Chapter4.part3;

import Chapter4.Dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExternalIteration {
    public static void main(String[] args) {
        // External Iteration
        // You iterate a collection externally, explicitly pulling out and processing the items one by one
        {
            // for-each construct is syntactic sugar that translates into something much uglier using an Iterator object.
            List<Dish> menu = Dish.menu;
            List<String> names = new ArrayList<>();
            for (Dish dish: menu){
                names.add(dish.getName());
            }
            System.out.println(names);
        }
        {
            // Using Iterators with while loop
            List<Dish> menu = Dish.menu;
            List<String> names = new ArrayList<>();
            Iterator<Dish> iterator = menu.iterator();
            while(iterator.hasNext()){
                Dish dish = iterator.next();
                names.add(dish.getName());
            }
            System.out.println(names);
        }
        {
            // Using Iterators with for loop
            List<Dish> menu = Dish.menu;
            List<String> names = new ArrayList<>();
            for (Iterator<Dish> iterator = menu.iterator(); iterator.hasNext();){
                Dish dish = iterator.next();
                names.add(dish.getName());
            }
            System.out.println(names);
        }
    }
}
