package ch10;

public class Formatter {
    public static void main(String[] args) {
        String s = String.format("Меня зовут %s и мне %d лет", "Юра", Integer.valueOf("12"));
        System.out.println(s);
    }
}
