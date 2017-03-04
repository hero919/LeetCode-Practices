import java.util.*;

/**
 * Created by zeqingzhang on 2/4/17.
 */
public class skyLine02 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0){
            return result;
        }

        List<int[]> b = new ArrayList<>();

        for(int[] building : buildings){
            int left = building[0];
            int right = building[1];
            int height = building[2];
            b.add(new int[]{
                    left, -height
            });
            b.add(new int[]{
                    right, height
            });
        }

        Collections.sort(b, (a, c) -> {
            if(a[0] != c[0])
                return a[0] - c[0];
            return a[1] - c[1];
        });

        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });

        queue.add(0);
        int pre = 0;
        for(int[] e : b){
            if(e[1] < 0){
                queue.offer(-e[1]);
            }else{
                queue.remove(e[1]);
            }

            int curr = queue.peek();
            if(curr != pre){
                pre = curr;
                result.add(new int[]{
                        e[0]
                        , curr});
            }
        }
        return result;
    }

    public static void main(String[] args){
        skyLine02 s = new skyLine02();
        int[][] buildings = new int[][]{
                new int[]{0, 2, 3},
                new int[]{2, 5, 3}
        };

        s.getSkyline(buildings);
    }
}
