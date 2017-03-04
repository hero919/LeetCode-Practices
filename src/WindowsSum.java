import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zeqingzhang on 3/3/17.
 */
public class WindowsSum {
    public int[] winSum(int[] nums, int k) {
        // write your code here

        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int size = (k > nums.length) ? 1 : nums.length - k + 1;
        int[] result = new int[size];
        Queue<Integer> queue = new LinkedList<>();
        int preSum = 0;
        int index = 0;
        int i = 0;
        for( ; i < k ; i++){
            preSum += nums[i];
            queue.add(nums[i]);
        }
        result[index++] = preSum;

        for(; i < nums.length; i++){
            preSum -= queue.poll();
            preSum += nums[i];
            result[index++] = preSum;
            queue.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args){
        WindowsSum w = new WindowsSum();
        System.out.println(Arrays.toString(w.winSum(new int[]{
                1,2,7,8,5
        }, 3)));


    }

}
