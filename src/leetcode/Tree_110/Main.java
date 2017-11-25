package leetcode.Tree_110;

/**
 * Created by felix on 15/6/23.
 */
public class Main {

    class Foo {
        int var;

        @Override
        public String toString() {
            return "Foo{" +
                    "var=" + var +
                    '}';
        }
    }

    public void test() {
        Foo foo = new Foo();
        func(foo);
        System.out.println(foo.toString());     //output:Foo{var=10}
    }

    private void func(Foo foo) {
        foo.var = 10;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.test();
    }
}
