import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by zeqingzhang on 11/19/16.
 */
public class MinSlidingWindows {
    public int[] minSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }

        int size = nums.length;
        if(size <= k){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                max = Math.max(nums[i], max);
            }
            return new int[]{
                    max
            };
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[size - k + 1];
        int tracker = 0;
        for(int i = 0; i < size; i++){
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] > nums[i]){
                deque.removeLast();
            }

            deque.offer(i);
            if(i >= k - 1){
                result[tracker++] = nums[deque.peek()];
            }
        }

        return result;

    }


    public static void main(String[] args){
        MinSlidingWindows m = new MinSlidingWindows();
        int[] nums = new int[]{
                1,3,-1,-3,5,3,6,7
        };
        System.out.println(Arrays.toString(m.minSlidingWindow(nums, 3)));
    }
}
