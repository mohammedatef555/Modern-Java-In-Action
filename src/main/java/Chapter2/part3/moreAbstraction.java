package Chapter2.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Predicate<T> {
    boolean test(T t);
}


public class moreAbstraction {
    public static <T> List<T> filter(List <T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t:list){
            if (p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        for (Integer num: evenNumbers) {
            System.out.println(num);
        }
    }
}
