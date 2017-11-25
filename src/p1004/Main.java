package p1004;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=0;
        double sum=0;
        while (sc.hasNext()) {
            double money = sc.nextDouble();
            sum+=money;
            n++;
        }
        System.out.println("$" + sum / n);

    }
}
