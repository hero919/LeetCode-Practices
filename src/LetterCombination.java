/**
 * Created by zeqingzhang on 1/19/17.
 */
import java.util.*;
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> list = new ArrayList<>();
        for(Character s : digits.toCharArray()){
            String string = map.get(s);
            list.add(string);
        }
        dfs(list, 0, "", result);
        return result;
    }



    private void dfs(List<String> list, int i,  String s, List<String> result){
        if(i == list.size()){
            result.add(s);
            return;
        }

        for(int j = 0; j < list.get(i).length(); j++){
                s = s + list.get(i).charAt(j);
                dfs(list, i + 1, s, result);
                s = s.substring(0, s.length() -1);
        }
    }


    public static void main(String[] args){
        LetterCombination l = new LetterCombination();
        System.out.println(l.letterCombinations("23"));
    }
}

