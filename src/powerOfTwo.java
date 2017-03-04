/**
 * Created by zeqingzhang on 12/21/16.
 */
public class powerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n ^ (n - 1)) == (2* n - 1);
    }
}
