/**
 * Created by zeqingzhang on 11/17/16.
 */

import java.util.*;
import java.lang.*;
public class KClosestPoints {
    public class Point {
        double x;
        double y;
        public Point(double a, double b) {
            x = a;
            y = b;
        }
    }




    public Point[] Solution(Point[] array, Point origin, int k) {

        class comparator implements Comparator<Point>{
            @Override
            public int compare(Point p1, Point p2) {
                return (int) (getDistance(p1, origin) - getDistance(p2, origin));
            }
        }


        PriorityQueue<Point> queue = new PriorityQueue<Point>(array.length, new comparator());
        for(Point p : array){
            queue.offer(p);
        }

        Point[] result = new Point[k];
        for(int i = 0; i < k; i++){
            result[i] = queue.poll();
        }
        return result;
    }


    private double getDistance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }


    public static void main(String[] args){

    }
}
