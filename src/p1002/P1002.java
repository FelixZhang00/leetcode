package p1002;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by felix on 15/3/27.
 * 算法没问题，但超时了。
 */
public class P1002 {


    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        String numbers[] = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.next();
        }
        stdLizationAll(numbers);

        checkDup(numbers);

    }

    /**
     * 检查重复的号码
     *
     * @param numbers
     */
    private static void checkDup(String[] numbers) {
        boolean isDup = false;


        for (int i = 0; i < numbers.length; ) {

            String num1 = numbers[i];
            int count = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                String num2 = numbers[j];
                if (num1.equals(num2)) {
                    i++;
                    count++;
                }else {
                    i++;
                    break;
                }

            }
            if (count > 1) {
                isDup = true;
                System.out.println(num1 + " " + count);
            }
        }
        if (!isDup) {
            System.out.println("No duplicates.");
        }

    }

    /**
     * 标准化全部的号码
     *
     * @param numbers
     */
    private static void stdLizationAll(String[] numbers) {


        for (int i = 0; i < numbers.length; i++) {
            String num = numbers[i];
            numbers[i] = convert(num);
        }
        Arrays.sort(numbers);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }


    }

    private static String convert(String num) {
//        Matcher matcher= Pattern.compile("-").matcher(num);
        String newNum = num.replaceAll("-", "");
        newNum = newNum.replaceAll("[ABC]", "2");
        newNum = newNum.replaceAll("[DEF]", "3");
        newNum = newNum.replaceAll("[GHI]", "4");
        newNum = newNum.replaceAll("[JKL]", "5");
        newNum = newNum.replaceAll("[MNO]", "6");
        newNum = newNum.replaceAll("[PRS]", "7");
        newNum = newNum.replaceAll("[TUV]", "8");
        newNum = newNum.replaceAll("[WXY]", "9");

        newNum = newNum.substring(0, 3) + "-" + newNum.substring(3, newNum.length());
        return newNum;
    }


}
