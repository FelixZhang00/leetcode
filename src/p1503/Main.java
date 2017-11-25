package p1503;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by felix on 15/4/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        BigDecimal total=new BigDecimal("0");
        BigDecimal bigDecimal;
        while (!str.equals("0")){
             bigDecimal=new BigDecimal(str);
             total=total.add(bigDecimal);
            str=scanner.nextLine();
        }
        System.out.println(total.toPlainString());
    }
}
