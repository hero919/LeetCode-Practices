import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 1/22/17.
 */
public class QueueReconstructionByHeight {
    public List<List<Integer>> reconstructQueue(List<List<Integer>> people) {
        List<List<Integer>> result = new ArrayList<>();
        if(people == null || people.size() == 0 || people.get(0) == null || people.get(0).size() == 0){
           return result;
        }

        List<List<List<Integer>>> r = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        int i = people.size();
        helper(r, temp, i, people);
        return r.get(0);
    }

    private void helper(List<List<List<Integer>>> result, List<List<Integer>> temp, int count, List<List<Integer>> people){
        if(temp.size() == count){

            result.add(new ArrayList<List<Integer>>(temp));
            return;
        }

        for(int i = 0; i < people.size(); i++){
            if(isValid(temp, people.get(i), count)){
                temp.add(people.get(i));
                helper(result, temp, count, people);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isValid(List<List<Integer>> temp, List<Integer> input, int count){
        int h = input.get(0);
        int k = input.get(1);
        int countHigher = 0;
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).get(0) >= h){
                countHigher++;
            }
        }
        if(k == countHigher){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        List<List<Integer>> people = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(7);
        l1.add(0);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(7);
        l3.add(1);
        List<Integer> l4 = new ArrayList<>();
        l4.add(5);
        l4.add(0);
        List<Integer> l5 = new ArrayList<>();
        l5.add(6);
        l5.add(1);
        List<Integer> l6 = new ArrayList<>();
        l6.add(5);
        l6.add(2);
        people.add(l1);
        people.add(l2);
        people.add(l3);
        people.add(l4);
        people.add(l5);
        people.add(l6);

        QueueReconstructionByHeight q = new QueueReconstructionByHeight();
        System.out.println(q.reconstructQueue(people));
    }

}
