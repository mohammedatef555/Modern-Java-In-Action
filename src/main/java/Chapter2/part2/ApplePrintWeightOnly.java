package Chapter2.part2;

import Chapter2.Apple;

public class ApplePrintWeightOnly implements ApplePrint{
    @Override
    public void print(Apple apple) {
        System.out.println("Apple weight = " + apple.getWeight());
    }
}
