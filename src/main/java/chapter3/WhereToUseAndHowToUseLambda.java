package chapter3;

// You can use a lambda expression in the context of a functional interface
public class WhereToUseAndHowToUseLambda {
    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {
        Adder adder = (int a1, int a2) -> a1 + a2;
        System.out.println(adder.add(1,2));
        System.out.println(adder.add(10,20));

        Runnable r1 = () -> System.out.println("Hello World 1");
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("Hello World 3"));
        // understand that a lambda expression can be assigned to a variable or passed to a method expecting
        // a functional interface as argument, provided the lambda expression has the same signature as the
        // abstract method of the functional interface.
    }
}
