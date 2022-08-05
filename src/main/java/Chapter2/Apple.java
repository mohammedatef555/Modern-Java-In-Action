package Chapter2;

import java.util.List;

public class Apple {
    private int id;
    private Color color;
    private int weight;

    public Apple() {

    }

    public Apple(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public Apple(int id, Color color, int weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static void printApples(List<Apple> apples) {
        for (Apple apple: apples)
            System.out.println(apple);
    }

    @Override
    public String toString() {
        return String.format("Apple id = %d has color = %s, and weight = %d", id, color, weight);
    }
}
