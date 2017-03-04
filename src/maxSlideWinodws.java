import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by zeqingzhang on 11/25/16.
 */
public class maxSlideWinodws {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <=0){
            return new int[0];
        }

        int size = nums.length - k + 1;
        int tracker = 0;
        int[] result = new int[size];
        if(k >= nums.length){
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                max = Math.max(max, nums[i]);
            }
            return new int[]{
                    max
            };
        }


        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.add(i);
            if(i >= k - 1){
                result[tracker++] = nums[deque.peek()];
            }
        }
        return result;

    }

    public static void main(String[] args){
        maxSlideWinodws m = new maxSlideWinodws();
        System.out.println(Arrays.toString(m.maxSlidingWindow(new int[]{7, 2, 4}, 2)));

    }
}

