/**
 * Created by zeqingzhang on 11/6/16.
 */
public class QuickSort03 {
    public void sortIntegers2(int[] A) {
        // Write your code here
        if(A == null || A.length == 0){
            return;
        }
        int start = 0;
        int end = A.length - 1;
        quickSort(A, start, end);
    }


    private void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int mid = start + (end - start)/2;

        int pivot = nums[mid];
        while(left <= right){
            while(nums[left] < pivot && left <= right){
                left++;
            }

            while(nums[right] > pivot && left <= right){
                right--;
            }

            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        System.out.print("left is: " + left + "   ");
        System.out.print("right is: " + right + "   ");
        System.out.print("The pivot is: " + pivot + "   ");
        System.out.print("The current Array is: ");
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
        System.out.println();


        quickSort(nums, left, end);
        quickSort(nums, start, right);

    }

    public static void main(String[] args){
        QuickSort03 q = new QuickSort03();
        q.sortIntegers2(new int[]{
                1,7,5,2,3
        });


    }

}
