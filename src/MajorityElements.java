import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 12/18/16.
 */
public class MajorityElements {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        int candidate1 = nums[0], candidate2 = nums[0], count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }
        }


        if(count1 > nums.length/3){
            result.add(candidate1);
        }
        if(count2 > nums.length/3){
            result.add(candidate2);
        }


        return result;
    }


    public static void main(String[] args){
        MajorityElements m = new MajorityElements();
        int[] input = new int[]{
            1,2
        };
        System.out.println(m.majorityElement(input));
    }
}
