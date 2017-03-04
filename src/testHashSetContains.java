import java.util.HashSet;

/**
 * Created by zeqingzhang on 2/19/17.
 */

class testContains{
    int label;
    String name;
    testContains(int label, String name){
        this.label = label;
        this.name = name;
    }
}
public class testHashSetContains {
    public static void main(String[] args){
        HashSet<testContains> set = new HashSet<>();

        testContains t0 = new testContains(2, "t0");
        testContains t1 = new testContains(2, "t0");

        set.add(t0);

        testContains t2 = t0;
        System.out.println(set.contains(t2));
        System.out.println(set.contains(t1));
    }
}
