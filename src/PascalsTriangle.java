import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zeqingzhang on 2/8/17.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }




    public int[] mergeSort(int[] array){
        if(array == null || array.length == 0){
            return array;
        }

        int[] newArray = new int[array.length];
        merge(array, 0, array.length - 1, newArray);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(newArray));
        return newArray;

    }


    private void merge(int[] array, int start, int end, int[] newArray){
        if(start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        merge(array, start, mid, newArray);
        merge(array, mid + 1, end, newArray);
        mergeProcess(array, start, mid, end, newArray);
    }


    private void mergeProcess(int[] array, int start, int mid, int end, int[] newArray){

        int left = start;
        int right = mid + 1;
        int i = start;

        while(left <= mid && right <= end){
            if(array[left] < array[right]){
                newArray[i] = array[left];
                i = i + 1;
                left = left + 1;
            }else{
                newArray[i++] = array[right++];
            }
        }

        while(left <= mid){
            newArray[i++] = array[left++];
        }

        while(right <= end){
            newArray[i++] = array[right++];
        }


        //Important because the array need to be sorted to make sure array[left] < array[right] can
        //be compared
        for(int j = start; j <= end; j++){
            array[j] = newArray[j];
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PascalsTriangle a = new PascalsTriangle();
        a.mergeSort(new int[]{
                1, 6, 4, 5, 3, 7, 9, 2
        });

    }
}
