import java.util.HashMap;
import java.util.Map;

/**
 * Created by zeqingzhang on 2/5/17.
 */


class Point{
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}




public class MaximumPointsInALine {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0){
            return 0;
        }

        int result = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
       for(int i = 0; i < points.length; i++){
            map.clear();
            int overlap = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for(int j = i + 1; j < points.length; j++){

            }
        }
        return 1;
    }



    private int getGCD(int a, int b){
        if(b == 0){
            return a;
        }
        return getGCD(b, a % b);
    }





    public static void main(String[] args){
        Integer i = 0;
        int j = 0;
        System.out.println(i == j);
        System.out.println(i.equals(j));


    }


}























