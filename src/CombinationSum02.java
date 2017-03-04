/**
 * Created by zeqingzhang on 2/20/17.
 */

import java.util.*;
public class CombinationSum02 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(num == null || num.length == 0){
            return result;
        }

        Arrays.sort(num);

        boolean[] tracker = new boolean[num.length];
        List<Integer> array = new ArrayList<>();
        helper(num, target, result, array, 0, tracker);
        return result;
    }



    private void helper(int[] num, int target, List<List<Integer>> result,
                        List<Integer> array, int index, boolean[] tracker){
        if(target == 0){
            result.add(new ArrayList<>(array));
            return;
        }

        for(int i = index; i < num.length; i++){
            if(!tracker[i]){
                array.add(num[i]);
                tracker[i] = true;
            }
            helper(num, target - num[i], result, array, index + 1, tracker);
            array.remove(array.size() - 1);
        }
    }



    public static void main(String[] args){
        CombinationSum02 c = new CombinationSum02();
        System.out.println(c.combinationSum2(new int[]{10,1,6,7,2,1,5}, 8));
    }

}
