package leetcode.String_65;

/**
 * Created by felix on 15/5/12.
 */
public class Solution {
    public boolean isNumber(String s) {
        try{
            Integer.parseInt(s.trim());
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
