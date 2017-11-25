package p1083.refer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NumberFormatException,
            IOException {

//        BufferedReader read = new BufferedReader(new InputStreamReader(
//                System.in));
        Scanner read = new Scanner(System.in);
        int t = read.nextInt(); //一共有t组测试数据
        int s;  //s张桌子将搬动
        int[][] m; //存放几组搬桌子起点终点的房间号

        int[] corridors = new int[200]; //过道下标为k(对应的房间号为2k-1和2k+2),其值表示桌子经过过道的次数
        int start; //开始的过道编号
        int len;   //搬桌子的距离
        int max;
        for (int i = 0; i < t; i++) {
            Arrays.fill(corridors, 0);  //对每组数据都重新初始化
            s = read.nextInt();
            m = new int[s][2];
            for (int j = 0; j < s; j++) {
                m[j][0] = read.nextInt();
                m[j][1] = read.nextInt();
            }

            //遍历所有桌子，更新corridors数组中的值
            for (int j = 0; j < s; j++) {
                //将房间号转化为对应的过道号
                if (m[j][0] % 2 == 0) {
                    m[j][0] = m[j][0] / 2 - 1;
                } else {
                    m[j][0] = m[j][0] / 2;
                }
                if (m[j][1] % 2 == 0) {
                    m[j][1] = m[j][1] / 2 - 1;
                } else {
                    m[j][1] = m[j][1] / 2;

                }

                len = Math.abs(m[j][0] - m[j][1]) + 1;
                start = Math.min(m[j][0], m[j][1]);
                for (int k = 0; k < len; k++) {
                    corridors[start + k]++;
                }
            }

            //找到某个搬桌子过程中经过次数最多的过道号，找到此最大的次数
            max = corridors[0];
            for (int j = 1; j < 200; j++) {
                if (corridors[j] > max) {
                    max = corridors[j];
                }
            }
            System.out.println(max * 10);
        }
    }
}