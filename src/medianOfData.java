import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by zeqingzhang on 1/18/17.
 */
public class medianOfData {
    public PriorityQueue<Integer> minheap, maxheap;
    public medianOfData() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }


    public static void main(String[] args){
        medianOfData m = new medianOfData();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        m.addNum(5);
        m.addNum(6);
        while(!m.maxheap.isEmpty()){
            System.out.println(m.maxheap.poll());
        }

        System.out.println("------------");
        while(!m.minheap.isEmpty()){
            System.out.println(m.minheap.poll());
        }
    }
}
