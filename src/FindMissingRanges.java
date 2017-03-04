import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 1/18/17.
 */
public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            result.add(buildRange(lower, upper));
            return result;
        }

        long pre = lower;
        for(int n : nums){
            String s = buildRange((long)pre, (long)n - 1);
            pre = n + 1;
            if(s.equals("")){
                continue;
            }
            result.add(s);
        }
        if(nums[nums.length - 1] == upper){
            return result;
        }
        result.add(buildRange(nums[nums.length - 1] + 1, upper));
        return result;
    }



    private String buildRange(long a, long b){

        if(a > b){
            return "";
        }

        if(a == b){
            return a + "";
        }

        return a + "->" + b;
    }

    public static void main(String[] args){
        FindMissingRanges f = new FindMissingRanges();
//        System.out.println(f.findMissingRanges(new int[]{
//                0, 1, 3, 50, 75
//        }, 0, 99));
//
//        System.out.println(f.findMissingRanges(new int[]{
//                 -1
//        }, -2, -1));
//
//        System.out.println(f.findMissingRanges(new int[]{
//                0, 100
//        }, 0, 100));

        System.out.println(f.findMissingRanges(new int[]{
                -2147483648, 2147483647
        }, -2147483648, 2147483647));
    }
}
