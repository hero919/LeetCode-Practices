/**
 * Created by zeqingzhang on 12/1/16.
 */
public class excel {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
    public static void main(String[] args){
        excel e = new excel();
        System.out.println(e.convertToTitle(27));
        int test = 27;
        System.out.println(--test);
    }

}
