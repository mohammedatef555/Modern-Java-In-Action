package Chapter3.part6;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class MethodReference {
    public static void main(String[] args) {
        ToIntFunction<String> toIntFunction = String::length; // (String s) -> s.length()
        System.out.println(toIntFunction.applyAsInt("ABC"));
        // (List<String> list, String item) -> list.contains(item);
        BiPredicate<List<String>, String> listStringBiPredicate = List::contains;
    }
}
