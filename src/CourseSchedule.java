import java.util.*;

/**
 * Created by zeqingzhang on 2/19/17.
 */
public class CourseSchedule {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] result = new int[numCourses];
        int index = 0;
        if(numCourses == 0 ||prerequisites == null){
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            if(map.containsKey(prerequisite[0])){
                map.put(prerequisite[0], map.get(prerequisite[0]) + 1);
            }else{
                map.put(prerequisite[0], 1);
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(map.containsKey(i)){
                continue;
            }
            queue.add(i);
            result[index++] = i;
        }


        if(queue.size() == 0){
            return new int[0];
        }


        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int[] prerequisite : prerequisites){
                if(prerequisite[1] == top){
                    int course = prerequisite[0];
                    int newValue = map.get(course) - 1;
                    map.put(course, newValue);
                    if(newValue == 0){
                        queue.add(course);
                        result[index++] = course;
                    }
                }
            }
        }

        if(index  != numCourses){
            return new int[0];
        }
        return result;
    }


    public static void main(String[] args){
        int[][] input = new int[][]{
            new int[]{1, 0}
        };

        System.out.print(Arrays.toString(findOrder(2, input)));
    }
}
