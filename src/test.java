import java.util.*;

/**
 * Created by zeqingzhang on 10/19/16.
 */
public class test {

    public static void main(String[] args){
//        Map<Integer, Integer> map = new HashMap<>();
//
//        map.put(1,10);
//        System.out.println(map.get(2));

//        int i = 0;
//        while(i < 10){
//            int j = i;
//            System.out.println(j);
//            i++;
//        }

//        int size = 10;
//        System.out.println(size - 1 - size/2);

//        ArrayList<Integer> array = new ArrayList<>();
//        array.add(1);
//        array.add(0);
//        System.out.println(array);
//        array.remove(new Integer(1));
//        System.out.println(array);

//        ArrayList<Integer> array = new ArrayList<>();
//        array.add(0);
//        array.add(1, 10);
//        //System.out.println(array);
//        Stack<Integer> stack = new Stack<>();
//        System.out.println(stack.peek());

        Deque<Integer> queue = new ArrayDeque<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);

//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        //queue.poll();
//        System.out.println(queue.peek());
//
//
//        Queue<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list.peek());
//
//
//        System.out.println("ab".substring(1,1));
//        System.out.println("ab".substring(1,2));
//
//        System.out.println("ab".compareTo("bc"));
//        Character c = '2';
//        System.out.println(Integer.valueOf(c));
//
//
//        LinkedList<Integer> l = new LinkedList<>();
//        l.add(1);
//        l.add(2);
//        System.out.println("The result is: " + l.remove());
//
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
        //System.out.println(a.r);
        //System.out.println(Integer.parseInt("12"));
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0, 2);

        //System.out.println(array);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        copy(l1, l2);
        System.out.println(l1);
        System.out.println(l2);
    }


    private static void copy(List<Integer> l1, List<Integer> l2){
        List<Integer> copy = l1;
        l1 = l2;

    }


    private List<Integer> test01(){
        return new ArrayList<>();
    }

}
