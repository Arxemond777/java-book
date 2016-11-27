package testClassnameLink;


import java.lang.Object;

public class ClassnameScope {

    public static void main(String [] args) {

        Bazz bazz = new Bazz(new Foo());
        int result = bazz.foo1;

        System.out.println("foo = " + result);


    }

}

class Foo {

    int foo = 123;

}

class FooFalse {

    int foo = 666;

}

class Bazz {

    int foo1;

    Bazz(Foo foo) {
        FooFalse fooFalse = new FooFalse();

        foo.foo = fooFalse.foo;
        foo1 = foo.foo;

        int xyi = 0;
        if (xyi != 0) {
            foo.foo = ++foo.foo;
            foo.foo = ++foo.foo;

        }
        {
            foo.foo = ++foo.foo;
            foo.foo = ++foo.foo;
        }

        foo1 = foo.foo;


    }

}
