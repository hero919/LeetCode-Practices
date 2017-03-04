/**
 * Created by zeqingzhang on 11/20/16.
 */
import java.util.*;
public class cs02 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <=0 || prerequisites == null){
            return new int[0];
        }

        int tracker = 0;
        int[] result = new int[numCourses];
        if(prerequisites.length == 0){
            for(int i = 0; i < numCourses; i++){
                result[i] = i;
            }
            return result;
        }
        //Course, times
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] require : prerequisites){
            int course = require[0];
            int pre = require[1];
            if(map.containsKey(course)){
                map.put(course, map.get(course) + 1);
            }else{
                map.put(course, 1);
            }
        }

        System.out.println(map);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(!map.containsKey(i)){
                result[tracker++] = i;
                queue.add(i);
            }
        }
        System.out.println(queue);

        if(queue.isEmpty()){
            return new int[0];
        }

        while(!queue.isEmpty()){
            int finished = queue.poll();
            for(int[] require: prerequisites){
                int course = require[0];
                int pre = require[1];
                if(pre == finished){
                    map.put(course, map.get(course) -1);

                    if(map.get(course) == 0) {
                        queue.add(course);
                        result[tracker++] = course;
                    }
                }
            }
        }

      return result;

    }


    public static void main(String[] args){
        int[][] array = new int[][]{
          new int[]{1, 0},
                new int[]{0, 1}

        };

        System.out.println(Arrays.toString(findOrder(2, array)));
    }
}
