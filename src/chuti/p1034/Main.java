package chuti.p1034;
import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.acmerblog.com/jiudu-1034-2215.html
 */
public class Main {

    static int arr[] = new int[100001];
    static int n,m;

    static PrintWriter out = new PrintWriter(System.out,false);
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        while(scan.hasNextInt()){

            n = scan.nextInt();
            m = scan.nextInt();
            if( n==0 && m==0)
                break;

            for(int i=0; i<n; i++) arr[i] = scan.nextInt();
            Arrays.sort(arr,0,n);
            if(m > n)
                m = n;

            if(m > 0)
                out.print(arr[n-1]);

            for(int i=2; i<=m; i++){
                out.print(" " + arr[n-i]);
            }
            out.println();


        }
        out.flush();
    }

}
/**************************************************************
 Problem: 1034
 User: coder
 Language: Java
 Result: Accepted
 Time:770 ms
 Memory:85116 kb
 ****************************************************************/
