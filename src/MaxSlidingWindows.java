import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by zeqingzhang on 11/16/16.
 */
public class MaxSlidingWindows {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        if(nums.length <= k){
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                result = Math.max(result, nums[i]);
            }
            return new int[]{
                    result
            };
        }

        int size = nums.length - k + 1;
        int[] result = new int[size];
        Deque<Integer> deque = new ArrayDeque<>();
        int t = 0;


        int firstElement = Integer.MIN_VALUE;
        for(int j = 0; j < k - 1; j++){
            firstElement = Math.max(firstElement, nums[j]);
        }
        deque.add(firstElement);

        for(int i = k; i < nums.length; i++){
            while(!deque.isEmpty() && i - deque.peekLast() > k){
                deque.removeLast();
            }

            while(!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            deque.add(i);
            result[t++] = deque.peekLast();
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{7, 2, 4};
        System.out.println(Arrays.toString(maxSlidingWindow(input, 2)));

    }

}
