/**
 * Created by zeqingzhang on 1/17/17.
 */
public class findPeakElement {
    public int findPeak(int[] num) {
        // write your code here
        int low = 0;
        int high = num.length-1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }

        System.out.println(low);
        System.out.println(high);
        return high;
    }

    public static void main(String[] args){
        int[] input = new int[]{
            1,2,3,1
        };

        findPeakElement p = new findPeakElement();
        p.findPeak(input);
    }
}
