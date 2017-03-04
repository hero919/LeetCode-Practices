import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zeqingzhang on 11/6/16.
 */
public class MergeSortedArrays {
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if(arrays == null || arrays.length == 0){
            return result;
        }

        if(arrays[0] == null || arrays[0].length == 0){
            return result;
        }

        int n = arrays.length;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            int size = arrays[i].length;
            for(int j = 0; j < size; j++){
                System.out.print(arrays[i][j] + " ");
                queue.add(arrays[i][j]);
            }
        }
        System.out.println("The size of queue is: " + queue.size());
        for(int i = 0 ; i < queue.size(); i++){
            System.out.println("Queue size is " + queue.size());
            System.out.println("Queue Peek is " + queue.peek());
            result.add(queue.poll());
        }

//        while(!queue.isEmpty()){
//            result.add(queue.poll());
//        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        int[] a1 = new int[]{
                1,3,5,7
        };
        int[] a2 = new int[]{
                2,4,6
        };
        int[] a3 = new int[]{
                0,8,9,10,11
        };
        int[][] sample = new int[][]{
                a1, a2, a3
        };
        MergeSortedArrays m = new MergeSortedArrays();
        m.mergekSortedArrays(sample);

    }
}
