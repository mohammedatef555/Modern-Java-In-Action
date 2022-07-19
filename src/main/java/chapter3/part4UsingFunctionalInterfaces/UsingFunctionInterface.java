package chapter3.part4UsingFunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UsingFunctionInterface {
    public static <T, R>List<R> map(List<T> list, Function<T, R> f) {
        List<R>  result = new ArrayList<>();
        for (T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(map(Arrays.asList("Apple", "Banana", "Watermelon"), (String text) -> text.length()));
    }
}
