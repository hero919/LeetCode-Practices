import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zeqingzhang on 2/21/17.
 */
public class WordBreakF {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if(wordDict == null || wordDict.size() == 0){
            return result;
        }

        Set<String> set = new HashSet<>();
        String resultString = "";
        helper(s, resultString, result, wordDict, set);
        return result;
    }



    private void helper(String s, String resultString, List<String> result, List<String> wordDict
            ,   Set<String> storeUsed){

        if(s.length() == 0){
            resultString = resultString.trim();
            result.add(resultString);
            return;
        }

        //String s = st;
        for(String string : wordDict){
            //String s = st;
            int index = 0;
            if(!storeUsed.contains(string) && s.startsWith(string)){
                index = index + string.length();
                resultString = resultString + string + " ";
                storeUsed.add(string);
                String st = s.substring(index);
                helper(st, resultString, result, wordDict, storeUsed);
            }
        }
    }





    public static void main(String[] args){
        String s = "code";
        List<String> set = new ArrayList<>();
        set.add("de");
        set.add("ding");
        set.add("co");
        set.add("code");
        set.add("lint");
        WordBreakF w = new WordBreakF();
        System.out.println(w.wordBreak(s, set));
        //System.out.println("hello".substring(2));
    }
}
