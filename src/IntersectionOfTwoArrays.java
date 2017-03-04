import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zeqingzhang on 10/25/16.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[]{};
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }

        for(int j : nums2){
            if(set.contains(j)){
                resultSet.add(j);
            }
        }

        int[] result = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        int count = 0;
       while(iterator.hasNext()){
           result[count++] = iterator.next();
       }

        return result;
    };



    public static void main(String[] args){

    }
}
