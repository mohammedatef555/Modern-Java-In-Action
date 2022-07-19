package chapter3.part1AndPart2;

// a functional interface is an interface that specifies exactly one abstract method

// @FunctionalInterface annotation isn’t mandatory, but it’s good practice to use
// it when an interface is designed for that purpose.
@FunctionalInterface
public interface Adder {
    int add(int a, int b);
}
