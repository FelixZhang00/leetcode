package leetcode.String_38;

/**
 * Created by felix on 15/5/28.
 */
public class Solution2 {
    public String countAndSay(int n) {
        if (n == 0) return null;

        String result = "1";
        int i = 1;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            //还有最后一个数
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }


        return result;
    }


}
