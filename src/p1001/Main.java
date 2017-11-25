package p1001;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by felix on 15/3/27.
 * 用java提供的BigDecimal数据类型处理高精度的问题
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            BigDecimal bd = scan.nextBigDecimal();
            int p = scan.nextInt();
            String plain = bd.pow(p).toPlainString();

            //去掉小数后面多余的0
            int endIndex = plain.length();

            for (int i = endIndex - 1; i > 0; i--) {
                if (plain.charAt(i) == '0') {
                    endIndex = i;
                } else {
                    break;
                }
            }
            plain = plain.substring(0, endIndex);


            //去掉开头的0
            if (plain.startsWith("0."))
                plain = plain.substring(1);

            if (plain.endsWith("."))
                plain = plain.substring(0, plain.length() - 1);
            System.out.println(plain);


        }


    }
}
