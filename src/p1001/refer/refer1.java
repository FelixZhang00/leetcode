package p1001.refer;

import java.math.BigDecimal;
import java.util.Scanner;

public class refer1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));

        while (scan.hasNext()) {
            BigDecimal bd = scan.nextBigDecimal();
            int p = scan.nextInt();

            String str = bd.pow(p).toPlainString();

            int endFlag = str.length();

            for (int i = endFlag - 1; i >= 0; i--) {
                if (str.contains(".") && str.charAt(i) == '0')
                    endFlag = i;
                else
                    break;
            }

            str = str.substring(0, endFlag);

            if (str.startsWith("0."))
                str = str.substring(1);

            if (str.endsWith("."))
                str = str.substring(0, str.length() - 1);

            System.out.println(str);
        }
    }
}  
