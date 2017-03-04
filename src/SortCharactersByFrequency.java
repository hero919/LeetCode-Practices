import java.util.HashMap;
import java.util.*;

/**
 * Created by zeqingzhang on 12/30/16.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = getFrequencyMap(s, map);
        ArrayList<Character>[] array = getFrequencyArray(map, max);
        String result = buildString(array, max);
        return result;
    }

    private int getFrequencyMap(String s, Map<Character, Integer> map){

        int max = 0;
        char[] array = s.toCharArray();
        for(Character c : array){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
            max = Math.max(map.get(c), max);
        }
        return max;
    }

    private ArrayList<Character>[] getFrequencyArray(Map<Character, Integer> map, int max){
        ArrayList<Character>[] array = new ArrayList[max + 1];
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Character, Integer> e : entrySet){
            if(array[e.getValue()] == null){
                ArrayList<Character> list = new ArrayList<>();
                list.add(e.getKey());
                array[e.getValue()] = list;
            }else{
                array[e.getValue()].add(e.getKey());
            }
        }
        return array;
    }

    private String buildString(ArrayList<Character>[] array, int max){
        StringBuilder s = new StringBuilder();
        for(int i = max; i >= 0; i--){
            if(array[i] != null){
                for(Character c : array[i]){
                    for(int j = 0; j < i; j++){
                        s.append(c);
                    }
                }
            }
        }
        return s.toString();
    }


    public static void main(String[] args){
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        System.out.println(s.frequencySort("Aabb"));
    }
}
