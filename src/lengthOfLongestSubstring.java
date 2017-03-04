/**
 * Created by zeqingzhang on 12/2/16.
 */
import java.util.*;
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int result = 1;
        int preMatch = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }else{
                preMatch = Math.max(preMatch , map.get(c) + 1);
            }
            result = Math.max(result, i - preMatch + 1);
        }

        return result;
    }

    public static void main(String[] args){
        lengthOfLongestSubstring l = new lengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcdaeb"));
    }
}
