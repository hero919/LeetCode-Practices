package Yahoo;

import java.util.Arrays;

/**
 * Created by zeqingzhang on 1/25/17.
 */
public class t214426 {
    public static void specialSort(int[] A){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            if(A[i] > max)
                max = A[i];
            if(A[i] < min)
                min = A[i];
        }
        System.out.println(min + " " + max);
        //Change all values to Positive
        for(int i=0; i<A.length; i++)
            A[i] = A[i] - min;

        System.out.println(Arrays.toString(A));
        int newMax = max-min+1;

        //Save original negative values into new positions
        int currNegativeIndex = 0;
        for(int i=0; i<A.length; i++)
            if(A[i]%newMax < (-min))
                A[currNegativeIndex++] += (A[i]%newMax)*newMax;
        //Save original positive values into new positions
        int currPositiveIndex = currNegativeIndex;
        for(int i=0; i<A.length; i++)
            if(A[i]%newMax > (-min))
                A[currPositiveIndex++] += (A[i]%newMax)*newMax;
        //Recover to original value
        for(int i=0; i<A.length; i++){
            A[i] = A[i]/newMax + min;
        }
    }


    public static void main(String[] args){
        int[] input = new int[]{
                3, -10, -2, -5, 10, 4, 5, -1, 10, 2, -4
        };

        t214426 t = new t214426();
        t.specialSort(input);
        System.out.println(Arrays.toString(input));
        System.out.println(3 - Integer.MIN_VALUE);
    }
}
