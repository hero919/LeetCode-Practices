import java.util.Arrays;

/**
 * Created by zeqingzhang on 12/7/16.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }

        int[] array = new int[citations.length + 1];
        for(int i = 0 ; i < citations.length; i++){
            if(citations[i] >= citations.length){
                array[array.length - 1]++;
            }else{
                array[citations[i]]++;
            }
        }
        System.out.println(Arrays.toString(array));
        int sum = 0;
        for(int j = citations.length - 1; j >= 0; j--){
            sum += array[j];
            if(sum >= j){
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        HIndex h = new HIndex();
        int[] input = new int[]{
                0
        };

        System.out.println(h.hIndex(input));
    }
}
