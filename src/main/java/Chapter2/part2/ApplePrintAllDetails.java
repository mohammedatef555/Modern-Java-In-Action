package Chapter2.part2;

import Chapter2.Apple;

public class ApplePrintAllDetails implements ApplePrint {
    @Override
    public void print(Apple apple) {
        System.out.println(apple);
    }
}
