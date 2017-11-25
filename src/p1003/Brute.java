package p1003;

import java.util.Scanner;

/**
 * Created by felix on 15/3/29.
 * 求至少需要多少张card可以达到指定的长度
 * 暴力解法 --居然Accepted
 * 因为题目假设length的最大值为5.20，所以循环最多也就执行273次
 */
public class Brute {
    public static void main(String[] args) {
        int n = 0;  //n张card可以达到指定的长度
        Scanner scan = new Scanner(System.in);
        double length = 0;
        while ((length = scan.nextDouble()) != 0.0) {

            double total = 0;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                n = i;
                total += 1.0 / (n + 1);
                if (total >= length) {
                    break;
                }
            }
            System.out.println(n + " card(s)");

        }

    }
}
