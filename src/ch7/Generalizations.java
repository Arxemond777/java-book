package ch7;

import java.lang.reflect.*;
import java.util.*;

public class Generalizations {
    public static void main(String [] args) {
        TypeVariable [] tv = List.class.getTypeParameters();
        System.out.println(Arrays.toString(tv));
    }
}
