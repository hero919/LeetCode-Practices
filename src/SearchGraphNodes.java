import java.util.*;

/**
 * Created by zeqingzhang on 2/19/17.
 */



//Definition for graph node.
  class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x; neighbors = new ArrayList<UndirectedGraphNode>();
      }
  };



public class SearchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if(graph == null || graph.size() == 0){
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode top = queue.poll();
            if(values.get(top) == target){
                return top;
            }
            List<UndirectedGraphNode> neighbors = top.neighbors;
            for(UndirectedGraphNode neighbor : neighbors){
                if(set.contains(neighbor)){
                    continue;
                }
                queue.add(neighbor);
            }
        }
        return null;
    }
}
