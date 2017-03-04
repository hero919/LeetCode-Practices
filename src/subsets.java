import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeqingzhang on 11/20/16.
 */
public class subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        ArrayList<Integer> subArray = new ArrayList<>();

        Arrays.sort(nums);
        helper(nums, subArray, result, 0);
        return result;
    }



    private static void helper(int[] nums, ArrayList<Integer> subArray, ArrayList<ArrayList<Integer>> result, int pos){


        result.add(new ArrayList<>(subArray));
        for(int i = pos; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1] && i != pos){
                continue;
            }
            subArray.add(nums[i]);
            helper(nums, subArray, result, i + 1);
            subArray.remove(subArray.size() - 1);
        }

    }

    public static void main(String[] args){
        int[] input = new int[]{
                1,2, 2, 3
        };
        System.out.println(subsets(input));

    }
}
