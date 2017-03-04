import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zeqingzhang on 10/24/16.
 */
public class reconstruct {
    HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> result = new LinkedList<String>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).offer(ticket[1]);
        }

        dfs("JFK");
        return result;
    }

    public void dfs(String s) {
        PriorityQueue<String> q = map.get(s);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }

        result.addFirst(s);
    }



    public static void main(String[] args){
        reconstruct r = new reconstruct();
        String[][] tickets = new String[][]{
                {"JFK", "ABC"},
                {"JFK", "BCD"},
                {"BCD", "LOL"},
                {"LOL", "JFK"}
        };
        System.out.println(r.findItinerary(tickets));
    }
}
