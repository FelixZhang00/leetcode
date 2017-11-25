package TestRarseUrl;

/**
 * Created by felix on 15/7/23.
 */
public class Main {

    public static void main(String[] args) {
//        A test = new B();
//        test.test();  //test from A

        B test = new B();
        test.test();  //test from B 因为子类隐藏掉了A 中的 test方法

    }
}
