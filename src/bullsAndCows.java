/**
 * Created by zeqingzhang on 12/29/16.
 */
import java.util.*;
public class bullsAndCows {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null){
            return "";
        }

        if(secret.length() == 0 && guess.length() == 0){
            return "";
        }

        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < secret.length(); i++){
            Character c = secret.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else{
                List<Integer> array = new ArrayList<>();
                array.add(i);
                map.put(secret.charAt(i), array);
            }

        }

        for(int j = 0; j < guess.length(); j++){
            Character c = guess.charAt(j);
            if(map.containsKey(c) && map.get(c).contains(j)){
                bulls++;
                map.get(c).remove(new Integer(j));
            }
        }

        for(int k = 0; k < guess.length(); k++){
            Character c = guess.charAt(k);
            if(map.containsKey(c) && map.get(c).size() > 0){
                map.get(c).remove(map.get(c).size() - 1);
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
    public static void main(String[] args){
        bullsAndCows b = new bullsAndCows();
        System.out.println(b.getHint("11", "10"));
    }

}
