/**
 * Created by zeqingzhang on 1/16/17.
 */
public class QuickSelect {



    //Find kth largest element
    public int quickSelect(int[] nums, int start, int end, int k){
        if(nums == null || nums.length == 0){
            return -1;
        }


        if(start == end){
            return nums[start];
        }

        int i = start;
        int j = end;
        while(i <= j){
            int mid = i + (j - i)/2;
            int pivot = nums[mid];
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
            quickSelect(nums, start, j, k);
        }

        if(start + k - 1 >= i){
            quickSelect(nums, i, end, k - (i - start));
        }



        return nums[j + 1];
    }



    public static void main(String[] args){
        System.out.println(2 << 3);
    }
}
