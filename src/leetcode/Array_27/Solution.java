package leetcode.Array_27;

/**
 * Created by felix on 15/4/3.
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A==null||A.length==0){
            return 0;
        }

        int len=0;
        for (int i = 0; i < A.length; i++) {
            if (elem!=A[i]){
                A[len++]=A[i];
            }
        }

       return len;
    }

    public static void main(String[] args) {

    }
}
