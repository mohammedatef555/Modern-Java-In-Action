package Chapter3.part6;

import Chapter2.Apple;
import Chapter2.Color;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConstructorReferences {
    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        Apple a1  = c1.get();
        BiFunction<Integer, Color, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(1,Color.RED);
        TriFunction<Integer, Color, Integer, Apple> c3 = Apple::new;
        c3.apply(2,Color.GREEN, 120);
    }
}
