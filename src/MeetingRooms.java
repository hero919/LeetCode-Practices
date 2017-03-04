/**
 * Created by zeqingzhang on 12/3/16.
 */
import java.util.*;

class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }


        @Override
        public String toString(){
            return "[" + start + "," + end + "]";
        }
     }
public class MeetingRooms {
    private class comp implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }

    }


    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }

        Queue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new comp());
        for(Interval i : intervals){
            queue.add(i);
        }

        Interval firstMeeting = queue.poll();
        int end = firstMeeting.end;
        while(!queue.isEmpty()){
            Interval nextMeeting = queue.poll();
            if(nextMeeting.start - end >=0){
                end = nextMeeting.end;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Interval i1 = new Interval(13,15);
        Interval i2 = new Interval(1,13);

    }

}
