package oo;

class ClassLoadTest {
    private String text="hello";

    public ClassLoadTest() {
        System.out.println();
    }

    public static void main(String[] args) {
        new Foo();
    }
}

class Foo extends ClassLoadTest{
    private static String text="hello";
    public Foo() {
        System.out.println();
    }
}

/***
 *
 */
