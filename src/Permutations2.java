import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 10/24/16.
 */
public class Permutations2 {
     public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         if(nums == null || nums.length == 0){
             return result;
         }

         List<Integer> set = new ArrayList<>();
         //0 means not visited
         int[] visited = new int[nums.length];
         helper(nums, set, result, visited);
         return result;
    }



    private void helper(int[] nums, List<Integer> set, List<List<Integer>> result, int[] visited){

        List<Integer> copy = new ArrayList<>(set);
        if(copy.size() == nums.length){
            result.add(copy);
        }

        for(int i = 0; i< nums.length ; i++){
            if(visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1]&& visited[i - 1]!= 0)){
                continue;
            }
            set.add(i);
            visited[i] = 1;
            helper(nums, set, result, visited);
            set.remove(set.size() - 1);
            visited[i] = 0;

        }
    }

    public static void main(String[] args){

    }
}
