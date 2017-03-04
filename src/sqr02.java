/**
 * Created by zeqingzhang on 11/22/16.
 */
public class sqr02 {
    public double sqrt(double x) {
        // Write your code here
        if(x <= 0){
            return 0;
        }
        double start = 0;
        double end = x;
        while(start + 0.000000000001 < end) {
            double mid = start + (double) ((end - start) / 2);
            double midSq = mid * mid;
            if (mid > 1) {
                if (midSq == x) {
                    return mid;
                } else if (midSq > x) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (midSq == x) {
                    return mid;
                } else if (midSq < x) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        System.out.println(start);
        System.out.println(end);

        if(x - start> end - x){
            return end;
        }else{
            return start;
        }
    }

    public static void main(String[] args){
        sqr02 s = new sqr02();

        System.out.println(s.sqrt(0.01));
    }
}
