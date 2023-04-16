package kotlininaction._8;

import kotlin.jvm.functions.Function2;

public class FirstClass_1 {

    public static int javaCalculator(int x, int y,
            Function2<Integer, Integer, Integer> operator) {
        System.out.println("Input: " + x + ", " + y);
        return operator.invoke(x, y);
    }

    public static void main(String[] args) {
        javaCalculator(1, 2, new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer invoke(Integer x, Integer y) {
                return x + y;
            }
        });
    }
}
