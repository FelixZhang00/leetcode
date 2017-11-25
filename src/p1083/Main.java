package p1083;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by felix on 15/3/31.
 * <p/>
 * source: http://poj.org/problem?id=1083
 */
public class Main {

    static class Pair {
        int from, to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //测试数据的组数


        for (int i = 0; i < N; i++) {
            int moves = scan.nextInt(); //共移动几张桌子

            for (int j = 0; j < moves; j++) {
                List<Pair> list = new ArrayList<Pair>();
                //读取两张桌子
                int s = scan.nextInt();
                int t = scan.nextInt();
                //room起点--》room终点
                //用2*k、2*k-1表示房间号，最后存储的是k
                Pair pair = new Pair((int) Math.ceil(s / 2.0), (int) Math.ceil(t / 2.0));
                list.add(pair);
                pair = null;

                process(list);

                //测试当前的list
//                for (int k = 0; k < list.size(); k++) {
//                    System.out.println(list.get(k));
//                }

                list = null;
            }

        }


    }


    /**
     * 主处理程序
     * @param list
     */
    private static void process(List<Pair> list) {

    }


}
