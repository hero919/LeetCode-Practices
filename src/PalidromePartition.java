import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 11/21/16.
 */
public class PalidromePartition {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        List<String> subArray = new ArrayList<>();
        helper(s, result, subArray, 0);
        return result;
    }



    private void helper(String s, List<List<String>> result, List<String> subArray, int pos){
        if(pos == s.length()){
            result.add(new ArrayList<>(subArray));
        }
        for(int i = pos + 1; i <= s.length(); i++){
            String prefix = s.substring(pos, i);
            if(!isPalidrome(prefix)){
                continue;
            }
            subArray.add(prefix);
            helper(s, result, subArray, i);
            subArray.remove(result.size() - 1);
        }
    }


    private boolean isPalidrome(String s){
        if(s == null || s.length() == 0){
            return true;
        }

        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        PalidromePartition p = new PalidromePartition();
        System.out.println(p.partition("a"));
        //System.out.println(p.isPalidrome("a"));
    }
}
