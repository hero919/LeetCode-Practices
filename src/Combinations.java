/**
 * Created by zeqingzhang on 12/8/16.
 */
import java.util.*;
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < k){
            return result;
        }

        List<Integer> subArray = new ArrayList<>();
        int pos = 1;
        helper(result, subArray, pos, n ,k);
        return result;
    }


    private void helper(List<List<Integer>> result, List<Integer> subArray, int pos, int n, int k){
        if(subArray.size() == k){
            result.add(new ArrayList<>(subArray));
        }

        for(int i = pos; i <= n; i++){
            subArray.add(i);
            helper(result, subArray, i + 1, n, k);
            subArray.remove(subArray.size() - 1);
        }
    }



    public static void main(String[] args){
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }
}
