/**
 * Created by zeqingzhang on 11/30/16.
 */
import java.util.*;
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        int begin = nums[0];
        int trackStart = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - 1 == begin){
                begin = nums[i];
                continue;
            }
            String range = makeRange(trackStart, begin);
            result.add(range);
            trackStart = nums[i];
            begin = nums[i];
        }

        result.add(makeRange(trackStart, begin));

        return result;
    }



    private String makeRange(int start, int end){
        if(start == end){
            return Integer.toString(start);
        }
        return start + "->" + end;
    }


    public static void main(String[] args){
        SummaryRanges s = new SummaryRanges();
        System.out.println(s.summaryRanges(new int[]{
                0,1,2,4,5,7
        }));

    }

}
