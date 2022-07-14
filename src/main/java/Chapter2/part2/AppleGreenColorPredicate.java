package Chapter2.part2;

import Chapter2.Apple;
import Chapter2.Color;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
