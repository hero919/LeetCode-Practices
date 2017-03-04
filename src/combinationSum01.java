import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zeqingzhang on 11/21/16.
 */
public class combinationSum01 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> array = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, array, result);
        return result;

    }


    public void helper(int[] candidates, int target, int i, List<Integer> array, List<List<Integer>> result){
        if(target == 0){
            ArrayList<Integer> copy = new ArrayList<>(array);
            result.add(copy);
            return;
        }

        for(int j = i; j< candidates.length; j++){
            if(candidates[j] > target){
                return;
            }

            array.add(candidates[j]);
            helper(candidates, target - candidates[j], j, array, result);
            array.remove(array.size() - 1);

        }
    }

    public static void main(String[] args){
        combinationSum01 c = new combinationSum01();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));

    }
}
