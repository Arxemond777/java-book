package amqp_my_test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GenericWildcard
{
    public static void main(String[] args) {
        List<?> a = new ArrayList<Integer>();
        GenericWildcard.Ggg b = new GenericWildcard().new Ggg();
//        a.add(b);
//        a.add(new Integer(1)); //Вообще сетерить незя, тк ? означает неопределенный тип

        /*Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if( o1 > o2 ){
                    return -1;
                }
                if( o1 < o2 ){
                    return 1;
                }
                return 0;
            }
        };*/

        Queue<Integer> intQueue = new PriorityQueue<>(10, (Integer o1, Integer o2) -> {
            if( o1 > o2 ){
                return -1;
            }
            if( o1 < o2 ){
                return 1;
            }
            return 0;
        });
        intQueue.add(1);
        intQueue.add(12);
        intQueue.add(8);
        while( !intQueue.isEmpty() ){
            System.out.println( intQueue.remove() );
        }
    }

    class Ggg {
        int i = 1;
    }
}
