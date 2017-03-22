package amqp_my_test;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcard
{
    public static void main(String[] args) {
        List<?> a = new ArrayList<Integer>();
        GenericWildcard.Ggg b = new GenericWildcard().new Ggg();
//        a.add(b);
//        a.add(new Integer(1)); //Вообще сетерить незя, тк ? означает неопределенный тип
    }

    class Ggg {
        int i = 1;
    }
}
