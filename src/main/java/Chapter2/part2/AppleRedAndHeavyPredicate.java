package Chapter2.part2;

import Chapter2.Apple;
import Chapter2.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return (Color.RED.equals(apple.getColor()))  && (apple.getWeight() > 150);
    }
}
