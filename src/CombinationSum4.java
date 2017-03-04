import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zeqingzhang on 1/23/17.
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (num > i)
                    break;
                else if (num == i)
                    res[i] += 1;
                else
                    res[i] += res[i-num];
            }
        }

        for(int i : res){
            System.out.println(i + " ");
        }
        return res[target];
    }

    public static void main(String[] args){
        CombinationSum4 c = new CombinationSum4();
        int[] nums = new int[]{
            1, 2, 3
        };
        c.combinationSum4(nums, 4);

//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        System.out.println(c.combinationSum4(nums, 4));
    }
}
