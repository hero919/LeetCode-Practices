import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 1/23/17.
 */
public class ZigZagIterator {
    List<Integer> list1 = null;
    List<Integer> list2 = null;
    int counter = -1;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        list1 = v1;
        list2 = v2;
    }

    public int next() {
        counter++;
        if(list1.size() == 0){
            return list2.remove(0);
        }

        if(list2.size() == 0){
            return list1.remove(0);
        }

        if(counter % 2 == 0){
            return list1.remove(0);
        }else{
            return list2.remove(0);
        }

    }

    public boolean hasNext() {
        return list1.size() != 0 || list2.size() != 0;
    }

    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);
        ZigZagIterator z = new ZigZagIterator(l1, l2);
        while(z.hasNext()){
            System.out.println(z.next());
        }
    }

}
