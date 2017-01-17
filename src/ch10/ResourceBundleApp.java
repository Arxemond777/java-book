package ch10;

import java.util.*;

public class ResourceBundleApp {
    public static void main(String[] args) throws MissingResourceException {
        try {
            ResourceBundle bun;

            bun = ResourceBundle.getBundle("ch10.Message", Locale.ITALY);//смотри в скомпилинах байт кодах
            System.out.println(bun.getString("HelloMessage"));

            bun = ResourceBundle.getBundle("ch10.Message", Locale.US);
            System.out.println(bun.getString("HelloMessage"));
        } catch (MissingResourceException e) {
            System.out.println("Cause: " + e);
        }

        /*try {
            RuntimeException e =  new RuntimeException();
            e.initCause(new RuntimeException("123"));

            throw e;
        } catch (RuntimeException e) {
            System.out.println(e.getCause());
        }
        System.out.println(1);*/
    }
}
