package ch12;

import java.io.*;
import java.net.Inet4Address;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BaseInputReadErrorAPI
{
    public static void main(String[] args) {
//        A();
//        B();
//        C()
//        D();
        E();
//        F();
    }


    static void A() {
        System.out.println("Enter charset");
        try {
            int val;
            while ((val = System.in.read()) != -1) {
                System.out.println((byte) val);
            }

            //System.exit(200);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void B() {
        byte[] b = new byte[1024];
        try {
            int got = System.in.read(b);
            System.out.println(got);
        } catch (IOException e) {

        } finally {
            try {
                System.in.close();
            } catch (IOException e) {
            }
        }
    }

    static void C() {
        try {
            int sizeArray = System.in.available();
            if (sizeArray > 0) { //Для файлов, но не для всего
                byte[] b = new byte[sizeArray];
                int info = System.in.read(b);
                System.out.println(info);
            }
        } catch (IOException e) {
        }

    }

    static void D() {
        try {
            System.out.println("Введите ЧИСЛО");

            InputStream in = System.in;
            InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inReader);
            String line = bufferedReader.readLine();
//            byte b = NumberFormat.getInstance().parse(line).byteValue();//конверт из числа в байты
            int i = NumberFormat.getInstance().parse(line).byteValue();//из байт в число
            System.out.println(i);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException ee) {
            System.out.println(ee);
        }
    }

    static void E() {
        System.out.println("Enter data: ");
        InputStream inputStream = new BufferedInputStream(System.in);
        System.out.print(inputStream);
    }

    static void F() {
        System.out.println("Enter data: ");
        try {
            DataInputStream dis = new DataInputStream(System.in);
            double d = dis.readDouble();
            System.out.println(d);
        } catch (IOException e) {

        }

    }
}
