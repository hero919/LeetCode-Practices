/**
 * Created by zeqingzhang on 12/4/16.
 */
import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        Queue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });


        for(Interval i : intervals){
            queue.add(i);
        }

        Interval top = queue.poll();
        result.add(top);
        while(!queue.isEmpty()){
            Interval next = queue.poll();
            System.out.println(next);
            if(top.end >= next.start){
                int newStart = top.start;
                int newEnd;
                if(top.end >= next.end){
                    newEnd = top.end;
                }else{
                    newEnd = next.end;
                }
                Interval interval = new Interval(newStart, newEnd);
                //queue.add(interval);
                top = interval;
                result.remove(result.size() - 1);
                result.add(interval);
            }else{
                top = next;
                result.add(top);
            }
        }
        return result;
    }

    //[1,3],[2,6],[8,10],[15,18],
    public static void main(String[] args){
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15 , 18);
        List<Interval> l = new ArrayList<>();
        l.add(i1);
        l.add(i2);
        l.add(i3);
        l.add(i4);
        MergeIntervals m = new MergeIntervals();
        System.out.println(m.merge(l));

    }
}
