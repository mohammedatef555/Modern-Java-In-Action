package chapter3.part4UsingFunctionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class UsingPredicateInterface {
    public static <T> boolean isIt(Predicate<T> predicate, T theValueToBeTested) {
        return predicate.test(theValueToBeTested);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        // is it even
        System.out.println(isIt((Integer i) -> i % 2 == 0, 1));
        System.out.println(isIt((Integer i) -> i % 2 == 0, 2));
        // is it odd
        System.out.println(isIt((Integer i) -> !(i % 2 == 0), 1));
        System.out.println(isIt((Integer i) -> !(i % 2 == 0), 2));
        // is it greater than 10
        System.out.println(isIt((Integer i) -> i > 10, 5));
        System.out.println(isIt((Integer i) -> i > 10, 100));
        // even and odd numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNums = filter(nums, (Integer num) -> num % 2 == 0);
        List<Integer> oddNums = filter(nums, (Integer num)-> num %2 != 0);
        System.out.println("Even nums from this list " + nums + " is:");
        System.out.println(evenNums);
        System.out.println("Odd nums from this list " + nums + " is:");
        System.out.println(oddNums);
        // Non-Empty Strings
        List<String> listOfStrings = Arrays.asList("Ahmed", "Mohamed", "", "","Ibra");
        List<String> nonEmptyStrings = filter(listOfStrings, (String text)-> !text.isEmpty());
        System.out.println("Non empty Strings " + nonEmptyStrings);
    }
}
