import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zeqingzhang on 1/25/17.
 */
public class Vector2D implements Iterator{
    int trackList = 0;
    int numInList = 0;
    List<List<Integer>> list = null;
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    @Override
    public Integer next() {
        int result = list.get(trackList).get(numInList);
        numInList++;
        if(numInList == list.get(trackList).size()){
            numInList = 0;
            trackList++;
        }


        return result;
    }

    @Override
    public boolean hasNext() {
        if(trackList >= list.size()){
            return false;
        }

        if(list.get(trackList).size() == 0){
            trackList++;
            numInList = 0;
            return hasNext();
        }

        return true;
    }


    public static void main(String[] args){
        List<Integer> l0 = new ArrayList<>();
        l0.add(1);
        l0.add(2);
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        List<List<Integer>> input = new ArrayList<>();
        input.add(l0);
        input.add(l1);
        input.add(l2);
        Vector2D v = new Vector2D(input);
        while(v.hasNext()){
            System.out.println(v.next());
        }

    }

}
