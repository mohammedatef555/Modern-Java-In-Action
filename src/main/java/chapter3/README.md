# Chapter 3
## _Lambda expressions_

## Sections

- 3.1. Lambdas in a nutshell
- 3.2. Where and how to use lambdas
- 3.3. Putting lambdas into practice: the execute-around pattern (behavior parameterization)
- 3.4. Using functional interfaces
- 3.5. Type checking, type inference, and restrictions
- 3.6. Method references

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
|  Compare two objects |  ```(Apple a1, Apple a2) ->  a1.getWeight().compareTo(a2.getWeight())``` |

# Where and how to use lambdas
## Where exactly can you use lambdas?
- You can use a lambda expression in the context of a functional interface.

# What is Functional interface?
- A functional interface is an interface that specifies exactly one abstract method.
- AKA Any interface with a SAM(Single Abstract Method) is a functional interface.

```java
// @FunctionalInterface isn’t mandatory, but it’s good practice 
// to use it when an interface is designed for that purpose.
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```


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
and check [UsingPredicateInterface.java](./part4UsingFunctionalInterfaces/UsingPredicateInterface.java) for more examples

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
and check [UsingConsumerInterface.java](./part4UsingFunctionalInterfaces/UsingConsumerInterface.java) for more examples

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
and check [UsingFunctionInterface.java](./part4UsingFunctionalInterfaces/UsingFunctionInterface.java) for more examples

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

#  3.5. Type checking, type inference, and restrictions

## Type checking:
The type of a lambda is deduced from the context in which the lambda is used. The type expected for the lambda expression inside the context (for example, a method parameter that it’s passed to or a local variable that it’s assigned to) is called the target- type. Let’s look at an example to see what happens behind the scenes when you use a lambda expression.

```java
List<Apple> heavierThan150g = filter(inventory, (Apple apple) -> apple.getWeight() > 150);
```
The type-checking process is deconstructed as follows:
- First, you look up the declaration of the filter method.
- Second, it expects, as the second formal parameter, an object of type Predicate<Apple> (the target type).
- Third, Predicate<Apple> is a functional interface defining a single abstract method called test.
- Fourth, the test method describes a function descriptor that accepts an Apple and returns a boolean.
- Finally, any argument to the filter method needs to match this requirement.

The code is valid because the lambda expression that we’re passing also takes an Apple as parameter and returns a boolean. Note that if the lambda expression was throwing an exception, then the declared throws clause of the abstract method would also have to match.

### Same lambda, different functional interfaces:
Because of the idea of target typing, the same lambda expression can be associated with different functional interfaces if they have a compatible abstract method signature.

```java
Callable<Integer> c = () -> 42;
PrivilegedAction<Integer> p = () -> 42;
```

```java
Comparator<Apple> c1 =
  (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
ToIntBiFunction<Apple, Apple> c2 =
  (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
BiFunction<Apple, Apple, Integer> c3 =
  (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
```

### Special void-compatibility rule:
If a lambda has a statement expression as its body, it’s compatible with a function descriptor that returns void (provided the parameter list is compatible, too). For example, both of the following lines are legal even though the method add of a List returns a boolean and not void as expected in the Consumer context (T -> void):

```java
// Predicate has a boolean return
Predicate<String> p = (String s) -> list.add(s);
// Consumer has a void return
Consumer<String> b = (String s) -> list.add(s);
```

## Type inference:
You can simplify your code one step further. The Java compiler deduces what functional interface to associate with a lambda expression from its surrounding context (the target type), meaning it can also deduce an appropriate signature for the lambda because the function descriptor is available through the target type. The benefit is that the compiler has access to the types of the parameters of a lambda expression, and they can be omitted in the lambda syntax. The Java compiler infers the types of the parameters of a lambda as shown here.

```java
Comparator<Apple> c =
  (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());      
Comparator<Apple> c =
  (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());                  
```
Note that sometimes it’s more readable to include the types explicitly, and sometimes it’s more readable to exclude them. There’s no rule for which way is better; developers must make their own choices about what makes their code more readable.

## Using local variables (capturing lambdas):
```java
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
```
There are some restrictions on what you can do with these variables. Lambdas are allowed to capture (to reference in their bodies) instance variables and static variables without restrictions. But when local variables are captured, they have to be explicitly declared final or be effectively final. Lambda expressions can capture local variables that are assigned to only once. (Note: capturing an instance variable can be seen as capturing the final local variable this.) For example, the following code doesn’t compile because the variable portNumber is assigned to twice:
```java
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);         
portNumber = 31337;
```
this restriction exists because local variables live on the stack and are implicitly confined to the thread they’re in. Allowing capture of mutable local variables opens new thread-unsafe possibilities, which are undesirable (instance variables are fine because they live on the heap, which is shared across threads).

# 3.6. Method references
Method references can be seen as shorthand for lambdas calling only a specific method.
Method reference is used to refer method of functional interface.
A method reference lets you create a lambda expression from an existing method implementation.
The target reference is placed before the delimiter :: and the name of the method is provided after it. For example, ```Apple::getWeight``` is a method reference to the method getWeight defined in the Apple class. (Remember that no brackets are needed after getWeight because you’re not calling it at the moment, you’re merely quoting its name.) This method reference is shorthand for the lambda expression:
```(Apple apple) -> apple.getWeight()```

## Recipes for constructing method references for three different types of lambda expressions:

### A method reference to a static method:

Lambda  | `(args) -> ClassName.staticMethod(args)`
------------- | -------------
Method Reference  | `ClassName::staticMethod`

### A method reference to an instance method of an arbitrary type:

Lambda  | `(arg0, rest) -> arg0.instanceMethod(rest)`
------------- | -------------
Method Reference  | `ClassName::instanceMethod`, Note: arg0 is of type ClassName.

### A method reference to an instance method of an existing object or expression:

Lambda  | `(args) -> expr.instanceMethod(args)`
------------- | -------------
Method Reference  | `expr::instanceMethod`

## Constructor references:
You can create a reference to an existing constructor using its name and the keyword new as follows: ClassName::new. It works similarly to a reference to a static method. For example, suppose there’s a zero-argument constructor. This fits the signature () -> Apple of Supplier; you can do the following:
```java
Supplier<Apple> c1 = Apple::new; // Constructor reference to the default Apple() constructor  
Apple a1 = c1.get(); // Calling Supplier’s get method produces a new Apple.   
```
This is equivalent to:
```java
Supplier<Apple> c1 = () -> new Apple(); // Lambda expression to create an Apple using the default constructor
Apple a1 = c1.get(); // Calling Supplier’s get method produces a new Apple.
```
If you have One-Argument Constructor:
```java
Function<Integer, Apple> c2 = Apple::new; // Constructor reference to Apple (Integer weight) for example
Apple a2 = c2.apply(110); // Calling Function’s apply method with a given weight produces an Apple.
```
this is equivalent to:
```java 
Function<Integer, Apple> c2 = (weight) -> new Apple(weight);    
Apple a2 = c2.apply(110);   
```

What if the constructor have 2 parametes like Apple(Integer weight, Color color)? well you can use BiFunction, BiFunction<T, U, R>
The function descriptor of the BiFunction is `(T t, U u) -> R`
```java
BiFunction<Integer, Color, Apple> c3 = Apple::new;      
Apple a3 = c3.apply(110, Color.GREEN);
// OR you can use lambda
BiFunction<Integer, Color, Apple> c3 = (color, weight) -> new Apple(color, weight);    
Apple a3 = c3.apply(110, Color.GREEN);
```

You saw how to transform zero-, one-, and two-argument constructors into constructor references. What would you need to do in order to use a constructor reference for a three-argument constructor such as RGB(int, int, int)?
You saw that the syntax for a constructor reference is ClassName::new, so in this case it’s RGB::new. But you need a functional interface that will match the signature of that constructor reference. Because there isn’t one in the functional interface starter set, you can create your own:
```java
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
```
```java
TriFunction<Integer, Color, Integer, Apple> c3 = Apple::new;
c3.apply(2,Color.GREEN, 120);
```

# Still Reading ... 👨🏻‍💻






