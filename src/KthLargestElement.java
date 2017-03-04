/**
 * Created by zeqingzhang on 1/13/17.
 */
public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }

        int i = start;
        int j = end;
        int mid = start + (end - start)/2;
        int pivot = nums[mid];
        while(i <= j){
            while(i <= j && nums[i] > pivot){
                i++;
            }

            while(i <= j && nums[j] < pivot){
                j--;
            }

            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if(start + k - 1 <= j){
            return quickSelect(nums, start, j, k);
        }

        if(start +  k - 1 >= i){
            return quickSelect(nums, i, end, k - (i - start));
        }

        return nums[j + 1];
    }
}
