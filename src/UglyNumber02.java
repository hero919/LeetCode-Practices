import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zeqingzhang on 11/20/16.
 */
public class UglyNumber02 {
    public static int nthUglyNumber(int n) {
        // Write your code here

        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                //if (!inQ.contains(primes[j] * number)) {
                    Q.add(number * primes[j]);
                    inQ.add(number * primes[j]);
                //}
            }
        }

        System.out.println(Q);
        System.out.println(inQ);
        return number.intValue();
    }

    public static void main(String[] args){
        nthUglyNumber(9);
    }


}
