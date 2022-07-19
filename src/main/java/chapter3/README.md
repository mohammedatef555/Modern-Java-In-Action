# Chapter 3
## _Lambda expressions_

## Sections

- 3.1. Lambdas in a nutshell
- 3.2. Where and how to use lambdas
- Still reading


## Lambda Syntax
A lambda expression is composed of parameters, an arrow, and a body.
```java
(parameters) -> expression
```
```java
(parameters) -> { statements; }
```
list of valid lambdas.
```java
(String s) -> s.length()
        (Apple a) -> a.getWeight() > 150
        (int x, int y) -> {
        System.out.println("Result:");
        System.out.println(x + y);
        }
        () -> 42
        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())     
```

## Examples of lambdas

| Use case  | Examples of lambdas |
| ------------- | ------------- |
| A boolean expression | ```(List<String> list) -> list.isEmpty()```  |
|  Creating objects |  ```() -> new Apple(10)``` |
|  Consuming from an object |  ```(Apple a) -> {System.out.println(a.getWeight());}``` |
| Select/extract from an object  |  ```(String s) -> s.length()``` |
| Combine two values  |  ```(int a, int b) -> a * b``` |
|  Compare two objects |  ```(Apple a1, Apple a2) ->         a1.getWeight().compareTo(a2.getWeight())``` |

# Where and how to use lambdas
## Where exactly can you use lambdas?
- You can use a lambda expression in the context of a functional interface.

# What is Functional interface?
- A functional interface is an interface that specifies exactly one abstract method.

# Function descriptor
- The signature of the abstract method of the functional interface describes the signature of the lambda expression.
- A lambda expression can be assigned to a variable or passed to a method expecting a functional interface as argument, provided the lambda expression has the same signature as the abstract method of the functional interface.


```java 
public void process(Runnable r) {
    r.run();
}
process(() -> System.out.println("This is awesome!!"));
```

# What about @FunctionalInterface?
- This annotation is used to indicate that the interface is intended to be a functional interface and is therefore useful for documentation. In addition, the compiler will return a meaningful error if you define an interface using the @FunctionalInterface annotation, and it isn’t a functional interface. For example, an error message could be “Multiple non-overriding abstract methods found in interface Foo” to indicate that more than one abstract method is available. Note that the @FunctionalInterface annotation isn’t mandatory, but it’s good practice to use it when an interface is designed for that purpose. You can think of it like the @Override notation to indicate that a method is overridden.


# Using functional interfaces
## common functional interfaces in The Java API:
### Working with a Predicate:
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
public <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> results = new ArrayList<>();
    for(T t: list) {
        if(p.test(t)) {
            results.add(t);
        }
    }
    return results;
}
Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
```
and check UsingPredicateInterface.java for more examples

### Working with a Consumer:

```Java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
public <T> void forEach(List<T> list, Consumer<T> c) {
    for(T t: list) {
        c.accept(t);
    }
}
forEach(Arrays.asList(1,2,3,4,5),(Integer i) -> System.out.println(i));
```
and check UsingConsumerInterface.java for more examples

### Working with a Function:

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
public <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for(T t: list) {
        result.add(f.apply(t));
    }
    return result;
}
// [7, 2, 6]
List<Integer> l = map(Arrays.asList("lambdas", "in", "action"),(String s) -> s.length());
```

### Primitive specializations:

Boxing: convert a primitive type into a corresponding reference type. ```int```-> ```Integer```
Unboxing: converting a reference type into a corresponding primitive type. ```Integer``` -> ```int```
Autoboxing: boxing and unboxing operations done automatically.
But this comes with a performance cost. Boxed values are a wrapper around primitive types and are stored on the heap. Therefore, boxed values use more memory and require additional memory lookups to fetch the wrapped primitive value, so Java 8 also added a specialized version of the functional interfaces in order to avoid autoboxing operations when the inputs or outputs are primitives. Like ```IntPredicate``` , so don't use ```Predicate<Integer> ``` use ```IntPredicate ``` instead.

### Examples of lambdas with functional interfaces:
|Use case | Example of lambda | Matching functional interface|
|---------| ----------------- | ------------------------------- |
| A boolean expression	 | ``` (List<String> list) -> list.isEmpty() ``` | ``` Predicate<List<String>>``` |
|Creating objects	 | ``` () -> new Apple(10)	 ``` |  ``` Supplier<Apple> ```|
| Consuming from an object	 | ```(Apple a) -> System.out.println(a.getWeight()) ``` | ``` Consumer<Apple>``` |
|Select/extract from an object	 |``` (String s) -> s.length()	 ```  | ``` Function<String, Integer> or ToIntFunction<String> ``` |
|Combine two values | ``` (int a, int b) -> a * b	 ``` | ``` IntBinaryOperator ``` |
| Compare two objects	 |``` (Apple a1, Apple a2) ->a1.getWeight().compareTo(a2.getWeight()) ```  | ``` Comparator<Apple> ``` |