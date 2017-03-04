import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by zeqingzhang on 11/17/16.
 */
public class MaxWindows {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0){
            return new int[0];
        }


        if(nums.length <= k){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < nums.length; j++){
                max = Math.max(nums[j], max);
            }
            return new int[]{
                    max
            };
        }


        int length = nums.length;
        int size = length - k + 1;
        int t = 0;
        int[] result = new int[size];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < length; i++){
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.removeLast();
            }

            deque.offer(i);
            if(i >= k - 1){
                result[t++] = nums[deque.peek()];
            }
        }

        return result;
    }


    public static void main(String[] args){
        int[] sample = new int[]{
                1, 3, 1, 2, 0, 5
        };
        MaxWindows m = new MaxWindows();

        System.out.println(Arrays.toString(m.maxSlidingWindow(sample, 3)));




    }

}
