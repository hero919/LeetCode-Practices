import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 12/22/16.
 */
public class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }
    public static void main(String[] args){
        findDuplicates f = new findDuplicates();
        int[] input = new int[]{
                1,1
        };
        System.out.println(f.findDuplicates(input));
    }
}
