package NPU_2015.C随机数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by felix on 15/5/16.
 */
public class Soultion {

    public static void main(String[] args) {
        int T = 1;
        int N = 10;

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            list.add(scan.nextInt());
        }
        Collections.sort(list);

        //去重
        int temp=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (temp==list.get(i)){

            }else{
                temp=list.get(i);
            }
        }


    }


}
