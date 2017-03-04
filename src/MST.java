import java.util.*;

/**
 * Created by zeqingzhang on 11/19/16.
 */
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}

public class MST {
    public static ArrayList<Connection> getLowCost02(ArrayList<Connection> connections) {
        //还是拿来输出
        ArrayList<Connection> result = new ArrayList<>();
        //这个是用来去重的
        Set<String> set = new HashSet<>();
        //每个string都要有个背后的string,这里用map来记录
        Map<String, String> map = new HashMap<>();
        //Kruskal算法就是先把这几条路排个序
        Collections.sort(connections, CostComparator);
        //初始化,把所有出现过的城市都加进去,同时每个城市都以自己为爹,map记录自己
        for (Connection c : connections) {
            String cityA = c.node1;
            String cityB = c.node2;
            set.add(cityA);
            set.add(cityB);
            map.put(cityA, cityA);
            map.put(cityB, cityB);
        }
        //这里其实写的简化了一点儿,对每个排出来的Connection进行检查是否成团
        for (Connection c : connections){
            //这里把检查成环和连成环写在了一起,有点儿非主流
            //union返回true说明两个点在这次从不同联盟里面联合在了一起
            if (union(c.node1, c.node2, map)){
                result.add(c);
            }
        }
        //如果点的个数不是比边多一条的话,那说明所有点不在同一个联盟啊
        if ((set.size() - 1) != result.size()){
            return null; //这里不能输出空的,test case告诉我的。
        }
        Collections.sort(result, NameComparator);
        return result;
    }
    //这里其实可以拆成两个function,一个是判断是否连接,另一个是把这两个点相连
//因为模板里union返回是void
    private static boolean union(String a, String b, Map<String, String> map){
        String aRoot = find(a, map);
        String bRoot = find(b, map);
        //这里加了个返回boolean值,就是图省事儿。
        if (aRoot.equals(bRoot)){
            return false;
        }
        //这里是把两个点联合在了一起。
        map.put(bRoot, aRoot);
        return true;
    }
    private static String find(String a, Map<String, String> map){
        if (a.equals(map.get(a))){
            return a;
        }
        //这里还是图省事儿用递归去找,其实迭代写法也很容易
        String parent = find(map.get(a), map);
        //这里多了一步路径压缩,其实没啥用
        map.put(a, map.get(map.get(a)));
        return parent;
    }
    //comparator单独拎出来写,或许能稍微酷炫一点儿
    static Comparator<Connection> CostComparator = new Comparator<Connection>() {
        public int compare(Connection a, Connection b) {
            return a.cost - b.cost;
        }
    };
    static Comparator<Connection> NameComparator = new Comparator<Connection>(){
        public int compare(Connection a, Connection b){
            if (a.node1.equals(b.node1)){
                return a.node2.compareTo(b.node2);
            }
            return a.node1.compareTo(b.node1);
        }



    };


    private static int unionNum;//这里开个全局变量，不丢人。
    //这个static是题目要求的，我自己一般不写，累。
    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections){
        //先把空的情形挡掉
        if (connections == null || connections.size() == 0){
            return new ArrayList<>();
        }

        ArrayList<Connection> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        //这里把cost小的往前排。
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });

        unionNum = 0;
        for (Connection c : connections){
            String a = c.node1;
            String b = c.node2;
            //看城市是不是连过了，要是可以连，那么就在result里面加上
            if (union(map, a, b)){
                result.add(c);
            }
        }
        //这里要检查一下,是不是所有的城市都属于同一个union
        String find = connections.get(0).node1;
        int union = map.get(find);
        for (String str : map.keySet()){
            // 如果我们中出了一个叛徒，返回空表
            if (map.get(str) != union){
                return new ArrayList<>();
            }
        }
        //这里最后要求按照城市的名字排序
        Collections.sort(result, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if(o1.node1.equals(o2.node1)){
                    return o1.node2.compareTo(o2.node2);
                }
                return o1.node1.compareTo(o2.node1);
            }
        });
        return result;
    }
    private static boolean union(Map<String, Integer> map, String a, String b){
        if (!map.containsKey(a) && !map.containsKey(b)){
            map.put(a, unionNum);
            map.put(b, unionNum);
            //这里用了一个新的没用过的数字
            unionNum++;
            return true;
        }
        //只有一方落单,那就加入有组织的一方
        if (map.containsKey(a) && !map.containsKey(b)){
            int aU = map.get(a);
            map.put(b, aU);
            return true;
        }
        if (!map.containsKey(a) && map.containsKey(b)){
            int bU = map.get(b);
            map.put(a, bU);
            return true;
        }
        //两个人都有团伙的情况。
        int aU = map.get(a);
        int bU = map.get(b);
        //如果是自己人,那肯定要踢掉,否则成环了
        if(aU == bU) return false;
        //把所有对方的团伙都吃进来
        for (String s : map.keySet()) {
            if (map.get(s) == bU) map.put(s, aU);
        }
        return true;
    }
    //这里还是测试用的
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

        ArrayList<Connection> res = getLowCost02(connections);
        for (Connection c : res){
            System.out.println(c.node1 + " -> " + c.node2 + " 需要花费大洋 : " + c.cost);
        }
    }
}
