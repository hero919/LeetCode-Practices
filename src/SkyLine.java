/**
 * Created by zeqingzhang on 12/28/16.
 */

import java.util.*;
public class SkyLine {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
    public List<int[]> getSkyline02(int[][] buildings) {
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

        int[][] buildings = new int[][]{
            new int[]{
                  0,1,3
            }
        };

        SkyLine s = new SkyLine();
        List<int[]> result = s.getSkyline02(buildings);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
        //System.out.println(s.getSkyline(buildings));
    }


}
