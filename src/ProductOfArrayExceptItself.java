import java.util.Arrays;

/**
 * Created by zeqingzhang on 2/4/17.
 */
public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for(int i = 1; i < length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        System.out.println(Arrays.toString(res));

        int right = 1;
        for(int j = length - 1; j >= 0; j--){
            res[j] = res[j] * right;
            right = right * nums[j];
        }
        return res;
    }

    public static void main(String[] args){
        ProductOfArrayExceptItself p = new ProductOfArrayExceptItself();
        p.productExceptSelf(new int[]{
           1, 2, 3, 4
        });
    }
}
