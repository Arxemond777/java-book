package ch9;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main (String[] args) {
        Test.a("a", "2");
    }

    static void a(String... args ) {
        System.out.println("x: " + Arrays.toString(args));
    }
}
