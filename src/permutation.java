import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 10/23/16.
 */
public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> array = new ArrayList<>();
        permuteHelper(nums, result, array);
        return result;
    }

    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> array){
        if(array.size() == nums.length){
            result.add(array);
        }

        List<Integer> copy = new ArrayList<>(array);
        for(int i = 0; i < nums.length; i++){
            if(copy.contains(nums[i])){
                continue;
            }

            copy.add(nums[i]);
            permuteHelper(nums, result, copy);
            copy.remove(copy.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] sample = new int[]{
                1, 2, 3
        };

        permutation p = new permutation();
        //System.out.println(p.permute(sample));

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> test01 = new ArrayList<>();
        test01.add(0);
        test01.add(1);
        test01.add(2);
        ArrayList<Integer> copy = new ArrayList<>(test01);
        System.out.println(test01);
        result.add(copy);
        copy.add(4);
        System.out.println(result);

    }

}
