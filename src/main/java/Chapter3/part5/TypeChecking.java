package Chapter3.part5;

import Chapter2.Apple;

import java.util.function.Predicate;

public class TypeChecking {
    public static void main(String[] args) {
        Predicate<Apple> applePredicate = (Apple a) -> a.getWeight() > 150;
        // What is the context in which the lambda is used? I mean what is the target type?
        // it's a functional interface - more specifically the target type is Predicate<Apple>
        // What is the abstract method in the Predicate<Apple> interface?
        // it's test : (Apple) -> boolean takes in Apple and returns boolean
        // so the function descriptor match the lambda expression we provided they both take an apple and return boolean
        // so the type checks.
    }
}
