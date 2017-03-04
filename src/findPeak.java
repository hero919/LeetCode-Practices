import javax.sound.midi.SysexMessage;

/**
 * Created by zeqingzhang on 12/18/16.
 */
public class findPeak {
    public int findPeakElement(int[] num){
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
        return low;
    }

    public static void main(String[] args){
        findPeak f = new findPeak();
        int[] input = new int[]{
            4, 10, 5, 6, 4, 3
        };
        System.out.println(f.findPeakElement(input));
    }
}
