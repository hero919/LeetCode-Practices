/**
 * Created by zeqingzhang on 12/31/16.
 */
public class SingleNumber03 {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args){
        int[] input = new int[]{
            1,1,1,2
        };
        SingleNumber03 s = new SingleNumber03();
        System.out.println(s.singleNumber(input));
    }
}
