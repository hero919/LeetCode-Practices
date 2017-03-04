import java.util.*;


/**
 * Created by zeqingzhang on 11/17/16.
 */


class Result{
    int id;
    int score;
    Result(int id, int score){
        this.id = id;
        this.score = score;
    }
}






public class HighFiveScores {

    class comparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2){
            return i2 - i1;
        }
    }


    public Map<Integer, Double> getHighFive(Result[] results){
        if(results.length == 0){
            return new HashMap<>();
        }

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(Result r : results){
            if(!map.containsKey(r.id)){
                PriorityQueue<Integer> queue = new PriorityQueue<Integer>(results.length,new comparator());
                queue.add(r.score);
                map.put(r.id, queue);
            }else{
                map.get(r.id).add(r.score);
            }
        }
        Map<Integer, Double> result = new HashMap<>();
        for(int key : map.keySet()){
            PriorityQueue<Integer>  q = map.get(key);
            double sum = 0;
            for(int i = 0; i < 5; i++){
                sum += q.poll();
            }
            double r = sum/5.0;
            result.put(key, r);
        }

        return result;
    }




    public static void main(String[] args){
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        HighFiveScores h = new HighFiveScores();
        Map<Integer, Double> res = h.getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}
