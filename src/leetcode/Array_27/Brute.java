package leetcode.Array_27;

/**
 * Created by felix on 15/4/3.
 * 不成功
 * 传参数组都没有改变
 */
public class Brute {
    public int removeElement(int[] A, int elem) {
        int currentLength = A.length;
        for (int i = 0; i < A.length; i++) {
            if (elem == A[i]) {
                currentLength--;
            }
        }

        int currentA[] = new int[currentLength];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (elem != A[i]) {
                currentA[j++] = A[i];
            }
        }

//        A=currentA; //只是改变了参数的引用，A[]在main函数中并没有变化
        A=new int[currentLength];
        for (int i = 0; i < currentLength; i++) {
            A[i] = currentA[i];
        }

        return currentLength;
    }

    public static void main(String[] args) {
        Brute b = new Brute();
        int A[] = new int[]{4, 5};
        int newlength = b.removeElement(A, 4);
        System.out.println("newlength = " + newlength);
        System.out.println("A.length = " + A.length);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
