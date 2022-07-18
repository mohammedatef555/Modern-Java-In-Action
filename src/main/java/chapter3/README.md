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