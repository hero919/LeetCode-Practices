import java.net.Inet4Address;
import java.util.*;

/**
 * Created by zeqingzhang on 11/18/16.
 */
public class CourseSchedule2 {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//        int[] result = new int[numCourses];
//        int tracker = 0;
//        if(prerequisites == null || prerequisites[0] == null||numCourses <= 0){
//            return new int[0];
//        }
//
//        if(prerequisites.length == 0){
//            for(int i = 0 ; i < numCourses; i++){
//                result[i] = i;
//            }
//        }
//
//        for(int i = 0; i < numCourses; i++){
//            ArrayList<Integer> value = new ArrayList<>();
//            map.put(i , value);
//        }
//        for(int[] array : prerequisites){
//            if(map.containsKey(array[0])){
//                map.get(array[0]).add(array[1]);
//            }else{
//                ArrayList<Integer> newArray = new ArrayList<>();
//                newArray.add(array[1]);
//                map.put(array[0], newArray);
//            }
//        }
//
//
//
//        for (Integer name: map.keySet()){
//
//            String key =name.toString();
//            String value = map.get(name).toString();
//            System.out.println(key + " " + value);
//
//
//        }
//
//
//        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
//            if(entry.getValue().size() == 0){
//                result[tracker++] = entry.getKey();
//                for(ArrayList<Integer> array : map.values()){
//                    if(array.contains(entry.getKey())){
//                        array.remove(new Integer(entry.getKey()));
//                    }
//                }
//            }
//        }
//        return result;
//    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return new int[0];
        }
        int[] result = new int[numCourses];
        int length = prerequisites.length;
        if(length == 0){
            for(int i = 0; i < numCourses; i++){
                result[i] = i;
            }
        }


       int[] counter = new int[numCourses];
        for(int[] array : prerequisites){
            counter[array[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(counter[i] == 0){
                queue.add(i);
            }
        }

        int numOfCourse = queue.size();
        while(!queue.isEmpty()){
            int next = queue.poll();
            for(int i = 0; i < counter.length; i++){
                if(prerequisites[i][1] == next){
                    counter[prerequisites[i][0]]--;
                    if(counter[prerequisites[i][0]] == 0){
                        queue.add(prerequisites[i][0]);

                    }
                }
            }

        }


        if(numOfCourse == numCourses){
            return result;
        }else{
            return new int[0];
        }



    }

    public static void main(String[] args){
        int[] array = new int[]{1, 0};
        int[] array02 = new int[]{0, 1};
        int[][] input = new int[][]{
                array02 , array
        };

        CourseSchedule2 c = new CourseSchedule2();
        System.out.println(Arrays.toString(c.findOrder(2, input)));


    }

}

