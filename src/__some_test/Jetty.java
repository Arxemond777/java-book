package __some_test;

public class Jetty
{
    public static void main(String[] args) {
        String Str = new String("Добро пожаловать на ProgLang.su");
        String SubStr1 = new String("обро");
        String SubStr2 = new String("Srog");

        System.out.println( Str.indexOf(SubStr1, 0));

        System.out.println(String.valueOf(1) == "1");
        System.exit(0);

        int i = 127, j = 2147483647;
        System.out.println(j * j * j);
    }
}
