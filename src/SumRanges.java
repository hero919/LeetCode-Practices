import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 2/12/17.
 */
public class SumRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }

    public static void main(String[] args){
        SumRanges s = new SumRanges();
        System.out.println(s.summaryRanges(new int[]{
                2, 3, 4, 5
        }));
        System.out.println(Integer.toBinaryString(100));
    }
}
