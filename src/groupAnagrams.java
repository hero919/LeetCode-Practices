import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zeqingzhang on 2/6/17.
 */
public class groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] array = new char[26];
            for(int i = 0; i < s.length(); i++){
                array[s.charAt(i) - 'a']++;
            }
            String ss = new String(array);
            if(map.containsKey(ss)){
                map.get(ss).add(s);
            }else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(ss, l);
            }
        }

        for(Map.Entry e : map.entrySet()){
            result.add((List)e.getValue());
        }

        return result;
    }
    public static void main(String[] args){
        groupAnagrams g = new groupAnagrams();
        System.out.println(g.groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }
}
