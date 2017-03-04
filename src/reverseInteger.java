/**
 * Created by zeqingzhang on 11/30/16.
 */
public class reverseInteger {
    public int reverse(int x) {
        int result = 0;
        int copy = x;
        while(copy != 0){
            int last = copy % 10;
            int temp = result;
            result  = result * 10 + last;
            if(result / 10 != temp){
                return 0;
            }
            copy = copy / 10;
        }
        return result;
    }

    public static void main(String[] args){
        reverseInteger r = new reverseInteger();
        System.out.println(r.reverse(123));
    }

}
