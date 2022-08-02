package chapter3.part5;

public class UsingLocalVariables {
    public static void main(String[] args) {
        // this will work
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        r.run();
        // this will not work
        // Because local variable used in lambda expression must be final or effectively final
        /*int portNumber2 = 1337;
        Runnable r2 = () -> System.out.println(portNumber2);
        portNumber2 = 1336;
        r2.run();*/
    }
}
