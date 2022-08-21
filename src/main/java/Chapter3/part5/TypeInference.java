package Chapter3.part5;

import Chapter2.Apple;

import java.util.Comparator;

public class TypeInference {
    public static void main(String[] args) {
        // The Java compiler infers the types of the parameters of a lambda
        // it can deduce an appropriate signature for the lambda because the function descriptor is
        // available through the target type. The benefit is that the compiler has access to the types of
        // the parameters of a lambda expression, and they can be omitted in the lambda syntax
        Comparator<Apple> c =
                (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
        Comparator<Apple> d =
                (a1, a2) -> a1.getWeight() - a2.getWeight();
    }
}
