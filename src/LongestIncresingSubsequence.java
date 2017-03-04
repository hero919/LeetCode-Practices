import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeqingzhang on 11/5/16.
 */
public class LongestIncresingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] tracker = new int[nums.length];
        int max = 0;
        for(int i= 0 ; i < nums.length; i++){
            tracker[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    tracker[i] = Math.max(tracker[i], tracker[j] + 1);
                }
            }
            max = tracker[i] > max ? tracker[i] : max;
        }
        System.out.println(Arrays.toString(tracker));
        return max;


    }
    public static void main(String[] args){
        LongestIncresingSubsequence l = new LongestIncresingSubsequence();
        int[] array = new int[]{
                88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59
        };
        System.out.println(l.longestIncreasingSubsequence(array));
    }
}
