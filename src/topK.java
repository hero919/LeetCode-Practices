import java.util.ArrayList;

/**
 * Created by zeqingzhang on 11/6/16.
 */
public class topK {
    public int[] topk(int[] nums, int k) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        quickSort(nums, 0, nums.length - 1);
        for(int i = nums.length - 1; i >= 0; i--){
            result.add(nums[i]);
        }

        int[] array = new int[k];
        for(int i = 0; i < result.size(); i++){
            array[i] = result.get(i);
        }

        return array;

    }




    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be
        // left <= right not left < right
        while (left <= right) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public static void main(String[] args){

    }
}
