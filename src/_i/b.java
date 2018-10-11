package _i;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class h1 implements aaaa {

        h1() {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("h:" + b.i.getAndIncrement());
            h1 h = new h1();
            b.hList.add(h);
        }
    }

public class b {

    static List<aaaa> hList = new LinkedList<>();
     static AtomicInteger i = new AtomicInteger();

    class h implements aaaa {

        h() {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("h:" + i.getAndIncrement());
            h h = new h();
            hList.add(h);
        }
    }

    private static final b b = new b();
    public static void main(String[] args) throws InterruptedException {
        new children();
//        new children().b();

//        ccccc children = new children();
//        children.b();
//        children.ooo();
//        Thread.sleep(100000);

//        children.l();
//        new children(1L);

//        b.new h();
        new h1();
    }
}

interface aaaa { }
interface ccccc {
    int b();
    default void ooo(){}; // (children.ooo(); - 9)
}

class parent implements ccccc {
    final int x; ////(new children() - 8 see construct on the line 38)
    static final int xx = 99; //(new children() - 0) init before all
    static int xxx = 99; //(new children() - 1)
    int y = 3;//(new children() - 5)

    static { //(new children() - 2) (children.l() - 2) (new children().b() - 2)
        System.out.println(1); // (children.ooo(); - 2)
    }
    { //(new children()- 6) (new children().b() - 6)
        System.out.println(5); // (children.ooo(); - 6)
    }

    parent() {//(new children()-7) (new children().b() - 7)
        System.out.println(2); // (children.ooo(); - 7)
        x = 33; //(new children() -8) - see final field on the line 25
    }

    parent (int i ) {
        System.out.println(3);
        x = i;
    }

    @Override
    public int b() { // (new children().b() - 8)
        System.out.println(4); // (children.ooo(); - 8)
        return 4;
    }
}

class children extends parent implements aaaa {
    final int x;///(new children() - 12 see construct on the line 38)
    static final int xx = 9; //(new children() - 0) init before all
    // i // (children.ooo(); - 9)
    int i = 5;// (new children()-9 before init (0) 9.1 after(5)) (new children().b() - 9)
    static int j = 1;//3 (children.l() - 3) (new children().b() - 3) // (children.ooo(); - 3)

    static { // (new children()-4) (children.l() - 4) (new children().b() - 4)
        System.out.println(1); // (children.ooo(); - 4)
    }
    { // (new children()- 10) (new children().b() - 10)
        System.out.println(5);
    }

    children() {//(new children()- 11) (new children().b() - 11)
        System.out.println(8); // (children.ooo(); - 7)
        x = 55; //(new children() -12) - see final field on the line 55
    }

    children(long l) {
        super(Math.toIntExact(l));
        System.out.println(6);
        x = (int) l;
    }

    static void l() { // (children.l() - 4)
        System.out.println(7);
    }
}