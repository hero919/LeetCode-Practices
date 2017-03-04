import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zeqingzhang on 11/12/16.
 */
public class subset02 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if ( S == null || S.size() == 0){
            return rst;
        }

        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst,list,S,0);
        return rst;
    }

    public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list,
                       ArrayList<Integer> S, int pos) {
        rst.add( new ArrayList(list));
        for ( int i = pos; i < S.size();i++){
            if ( i != pos && S.get(i) == S.get(i-1)){
                continue;
            }

            list.add(S.get(i));
            helper(rst,list,S,i+1);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, result, subset, 0);
        return result;
    }



    private void helper(int[] nums, List<List<Integer>> result, List<Integer> subArray, int pos){
        if(nums == null){
            return;
        }
        result.add(new ArrayList<>(subArray));
        for(int i = pos; i < nums.length; i++){
            if ( i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            subArray.add(nums[i]);
            helper(nums, result, subArray, i + 1);
            subArray.remove(subArray.size() - 1);
        }


    }

    public static void main(String[] args){
        int[] array = new int[]{
                1,2,2
        };
        ArrayList<Integer> array02 = new ArrayList<>();
        array02.add(1);
        array02.add(2);
        array02.add(2);

        subset02 s = new subset02();
        System.out.println(s.subsetsWithDup(array02));
        System.out.println(s.subsetsWithDup(array));
    }

}
