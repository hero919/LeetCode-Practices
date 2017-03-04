/**
 * Created by zeqingzhang on 11/19/16.
 */

import java.util.*;
import java.util.concurrent.CompletionException;

public class MST02 {
    private static int counter;
    static class comparaterCost implements Comparator<Connection>{
        @Override
        public int compare(Connection c1, Connection c2){
            return c1.cost - c2.cost;
        }
    }

    static class comparaterName implements Comparator<Connection>{
        @Override
        public int compare(Connection c1, Connection c2){
            if(c1.node1.compareTo(c2.node1) == 0){
                return c1.node2.compareTo(c2.node2);
            }
            return c1.node1.compareTo(c2.node1);
        }
    }


    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        if(connections == null || connections.size() == 0){
            return null;
        }

        ArrayList<Connection> result = new ArrayList<>();
        counter = 0;
        Map<String, Integer> map = new HashMap<>();

        Collections.sort(connections, new comparaterCost());

        for(Connection c : connections){
            String c1 = c.node1;
            String c2 = c.node2;
            if(union(map, c1, c2)){
                result.add(c);
            }
        }

        Collections.sort(result, new comparaterName());


        return result;

    }




    //If there is a cycle return false;
    private static boolean union(Map<String, Integer> map, String c1, String c2){
        if(!map.containsKey(c1) && !map.containsKey(c2)){
            map.put(c1, counter);
            map.put(c2, counter);
            counter++;
            return true;
        }

        if(!map.containsKey(c1) && map.containsKey(c2)) {
            int newValue = map.get(c2);
            map.put(c1 , newValue);
            return true;
        }


        if(map.containsKey(c1) && !map.containsKey(c2)) {
            int newValue = map.get(c1);
            map.put(c2 , newValue);
            return true;
        }


        //If different unions, Make the second oen to be the first one
        if(map.containsKey(c1) && map.containsKey(c2)){
            int newValue = map.get(c1);
            int oldValue = map.get(c2);

            if(newValue == oldValue){
                return false;
            }

            for(String city : map.keySet()){
                if(map.get(city) == oldValue){
                    map.put(city , newValue);
                }
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Connection> connections = new ArrayList<>();
        //这里还是一个苯环形状，有化学出身的看到这里可以鼓掌了
        connections.add(new Connection("A","B",6));
        connections.add(new Connection("B","C",4));
        connections.add(new Connection("C","D",5));
        connections.add(new Connection("D","E",8));
        connections.add(new Connection("E","F",1));
        connections.add(new Connection("B","F",10));
        connections.add(new Connection("E","C",9));
        connections.add(new Connection("F","C",7));
        connections.add(new Connection("B","E",3));
        connections.add(new Connection("A","F",1));

        ArrayList<Connection> res = getLowCost(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " 需要花费大洋 : " + c.cost);
        }
    }



}
