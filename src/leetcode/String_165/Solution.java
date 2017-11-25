package leetcode.String_165;

/**
 * Created by felix on 15/5/26.
 * https://leetcode.com/problems/compare-version-numbers/
 * 判断版本号的大小
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String v1, v2;
        int i1, i2;
        v1 = version1;
        v2 = version2;

        while (!isEmpty(v1) && !isEmpty(v2)) {
            i1 = parseHead(v1);
            i2 = parseHead(v2);
            if (i1 > i2) return 1;
            if (i1 < i2) return -1;

            v1 = divideHead(v1);
            v2 = divideHead(v2);
        }

        if (!isEmpty(v1)) {
            if(isZeros(v1))return 0;
            return 1;
        }
        if (!isEmpty(v2)){
            if(isZeros(v2))return 0;
            return -1;
        }

        return 0;
    }

    /**
     * 是否是0.0.0...的结构的字符串
     */
    private boolean isZeros(String s) {
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c!='0'&&c!='.')return false;
        }
        return true;
    }


    private boolean isEmpty(String s) {
        if (s == null || "".equals(s)) return true;
        return false;
    }


    /**
     * 获取‘.’前面的int型数据表示
     */
    private int parseHead(String s) {
        if (s.charAt(0) == '.') return 0;

        int i = 0;
        for (; i < s.length(); i++) {
            if ('.' == s.charAt(i)) break;
        }
        return Integer.parseInt(s.substring(0, i));
    }

    /**
     * 去掉头，保留‘.’之后的字符串
     */
    private String divideHead(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            if ('.' == s.charAt(i)) break;
        }
        if (i >= s.length()) return null;
        return s.substring(i + 1, s.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.compareVersion("1.6.5", "1.6.1");
        System.out.println(result);

        int result2 = solution.compareVersion("01", "1");
        System.out.println(result2);

        int result3 = solution.compareVersion("1.0.0.0.0", "1");
        System.out.println(result3);
    }
}
