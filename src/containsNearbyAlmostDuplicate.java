/**
 * Created by zeqingzhang on 12/17/16.
 */
import java.util.*;
public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0){
            return false;
        }
        if(t < 0 || k <= 0){
            return false;
        }

        long[] array = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            array[i] = (long)nums[i] - Integer.MIN_VALUE;
        }
        //Deque<Integer> deque = new ArrayDeque<>();
        Deque<Long> bucket = new ArrayDeque<>();

        for(int i = 0; i < array.length; i++){
            if(i > k){
                //deque.removeLast();
                bucket.removeFirst();
            }
            long bucketNum = array[i]/(t + 1);
            if(bucket.contains(bucketNum)){
                return true;
            }

            bucket.add(bucketNum);
        }
        return false;
    }



    public boolean containsNearbyAlmostDuplicate02(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }


    public static void main(String[] args){
        containsNearbyAlmostDuplicate c = new containsNearbyAlmostDuplicate();
        int[] nums = new int[]{
           5, 0, 6
        };
        System.out.println(c.containsNearbyAlmostDuplicate02(nums, 100, 5));
        //System.out.println(((long)1 - Integer.MIN_VALUE));
    }
}
