/**
 * Created by zeqingzhang on 12/30/16.
 */
import java.util.*;
public class AlienOrder {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }

    public String alienOrder02(String[] words) {
        String result = "";
        if(words == null || words.length == 0){
            return result;
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for(String word : words){
            char[] charArray = word.toCharArray();
            for(Character c : charArray){
                degree.put(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i + 1];
            int length = Math.min(curr.length(), next.length());
            for(int j = 0; j < length; j++){
                Character first = curr.charAt(j);
                Character second = next.charAt(j);
                if(first != second){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(first)){
                        set = map.get(first);
                    }

                    set.add(second);
                    map.put(first, set);
                    degree.put(second, degree.get(second) + 1);
                    break;
                }
            }
        }


        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> pair : degree.entrySet()){
            if(pair.getValue() == 0){
                queue.add(pair.getKey());
            }
        }

        while(!queue.isEmpty()){
            Character c = queue.poll();
            result = result + c;
            if(map.containsKey(c)){
                Set<Character> set = map.get(c);
                for(Character ch : set){
                    degree.put(ch, degree.get(ch) - 1);
                    if(degree.get(ch) == 0){
                        queue.add(ch);
                    }
                }
            }
        }

        if(!(result.length() == degree.size())){
            return "";
        }
        return result;
    }
    public static void main(String[] args){
        AlienOrder a = new AlienOrder();
        String[] words = new String[]{
                "wrtkj","wrt"
        };
        System.out.println(a.alienOrder(words));
    }
}
