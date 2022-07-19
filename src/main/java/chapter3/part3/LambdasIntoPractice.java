package chapter3.part3;

public class LambdasIntoPractice {
    public static String greetThisPerson(Greeting greeting, String name) {
        return greeting.greet(name);
    }

    public static void main(String[] args) {
        System.out.println(greetThisPerson((String name)-> "Hi, " + name, "John"));
        System.out.println(greetThisPerson((String name)-> "Hola, " + name, "Raul"));
        System.out.println(greetThisPerson((String name)-> "Ahlan, " + name, "Mohammed"));
    }
}
