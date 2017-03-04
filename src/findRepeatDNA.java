/**
 * Created by zeqingzhang on 12/15/16.
 */
import java.util.*;
public class findRepeatDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < 11){
            return result;
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String DNA = s.substring(i, i + 10);
            if(set.contains(DNA) && !result.contains(DNA)){
                result.add(DNA);
                continue;
            }
            set.add(DNA);
        }

        return result;

    }

    public static void main(String[] args){
        findRepeatDNA f = new findRepeatDNA();
        System.out.println(f.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

}
