/**
 * Created by zeqingzhang on 1/29/17.
 */
public class BitWise {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }


    public static void main(String[] args){
        BitWise b = new BitWise();
        System.out.println(9 & 1);
    }
}
