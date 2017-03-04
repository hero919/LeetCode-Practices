import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zeqingzhang on 11/13/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> subArray = new ArrayList<>();
        int pos = 0;
        helper(candidates, target, result, subArray, pos);
        return result;
    }



    private void helper(int[] candidates,
                        int target,
                        List<List<Integer>> result,
                        List<Integer> subArray,
                        int pos)
    {
//        if(calculateSum(subArray) == target){
//            result.add(subArray);
//            return;
//        }

        result.add(new ArrayList<Integer>(subArray));
        for(int i = pos; i < candidates.length; i++){
            if(i != 0 && candidates[i] == candidates[i - 1] && i > pos){
                continue;
            }
            subArray.add(candidates[i]);
            helper(candidates, target, result, subArray, i + 1);
            subArray.remove(subArray.size() - 1);

        }
    }




    private int calculateSum(List<Integer> array){
        int sum = 0;
        for(int i : array){
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] sample = new int[]{
                1,2,2,3
        };

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(2);
        array.add(3);
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(sample, 10));

    }
}
