/**
 * **********************************************************************
 * Created by felix on 15/3/20.
 * <p/>
 * Description:
 * Problems involving the computation of exact values of very large magnitude and
 * precision are common. For example, the computation of the national debt is a taxing
 * experience for many computer systems.
 * This problem requires that you write a program to compute the exact value of Rn
 * where R is a real number ( 0.0 < R < 99.999 ) and n is an integer such that 0 < n <= 25.
 * <p/>
 * <p/>
 * Input:
 * The input will consist of a set of pairs of values for R and n.
 * The R value will occupy columns 1 through 6, and the n value will be in columns 8 and 9.
 * <p/>
 * Output:
 * <p/>
 * The output will consist of one line for each line of input giving the exact value of R^n.
 * Leading zeros should be suppressed in the output. Insignificant trailing zeros must not be printed.
 * Don't print the decimal point if the result is an integer.
 * ***********************************************************************
 */

import java.util.Scanner;

public class Exponentiation {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double r = sc.nextDouble();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                r *= r;
            }
            System.out.println(r);
        }

    }
}
