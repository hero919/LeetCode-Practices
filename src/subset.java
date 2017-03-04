import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 10/19/16.
 */
public class subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> array = new ArrayList<>();
        if(nums == null){
            return array;
        }
        List<Integer> subset = new ArrayList<>();
        helper(nums, subset, array, 0);
        return array;



    }

    public void helper(int[] nums, List<Integer> subset, List<List<Integer>> result, int pos){
        List<Integer> newList = new ArrayList<>(subset);
        result.add(newList);
        for(int i = pos; i < nums.length ; i++){
            subset.add(nums[i]);
            helper(nums, subset, result, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args){
        subset s = new subset();
        System.out.println(s.subsets(new int[]{
                1,2,3,4
        }));
    }

}
