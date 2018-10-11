package _;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
    static String msg = "msg Error";

    public static void main(String[] args) {
        System.out.println(findADistance("(1.5,-2),(-2,30)"));
    }

    private static float findADistance(String coordinate) {
        String reg = "([-]?\\d*\\.?\\d+)";
        Pattern pattern = Pattern.compile(
                "\\("+reg+"\\,"+reg+"\\)\\,\\("+reg+"\\,"+reg+"\\)"
        );
        Matcher matcher = pattern.matcher(coordinate);

        if (matcher.matches()) {
            if (Float.parseFloat(matcher.group(2)) != Float.parseFloat(matcher.group(3)))
                throw new RuntimeException(msg);

            float
                x = Float.parseFloat(matcher.group(1)),
                y = Float.parseFloat(matcher.group(2)),
                z = Float.parseFloat(matcher.group(4));

            float dist = x + y + z;
            if (dist < 0.0)
                throw new RuntimeException(msg);

            return x + y + z;

        } else {
            throw new RuntimeException(msg);
        }
    }

}

