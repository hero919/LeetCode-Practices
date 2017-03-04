import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zeqingzhang on 12/3/16.
 */

class flag{
    int time;
    int tracker;
    public flag(int time, int tracker){
        this.time = time;
        this.tracker = tracker;
    }
}

class comp implements Comparator<flag> {
    @Override
    public int compare(flag f1, flag f2){
        if(f1.time == f2.time){
            return -(f1.tracker - f2.tracker);
        }
        return f1.time - f2.time;
    }
}
public class MeetingRooms02 {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Queue<flag> queue = new PriorityQueue<flag>(intervals.length * 2, new comp());
        for(Interval i : intervals){
            flag depart = new flag(i.start, 0);
            flag arrive = new flag(i.end, 1);
            queue.add(depart);
            queue.add(arrive);
        }
        int count = 0;
        int result = 0;
        while(!queue.isEmpty()){
            flag top = queue.poll();
            if(top.tracker == 0){
                count++;
            }else{
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }


    public static void main(String[] args){
        Interval i1 = new Interval(7,10);
        Interval i2 = new Interval(2,4);
        MeetingRooms02 m = new MeetingRooms02();
        Interval[] input = new Interval[]{
                i1, i2
        };

        System.out.println(m.minMeetingRooms(input));
    }

}
