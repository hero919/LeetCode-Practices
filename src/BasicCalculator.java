/**
 * Created by zeqingzhang on 12/8/16.
 */
import java.util.*;
import java.lang.*;
public class BasicCalculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }


        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add(' ');
        set.add(')');
        set.add('+');
        set.add('-');
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(set.contains(s.charAt(i))){
                q1.add(Integer.valueOf(c));
                continue;
            }


            for(int j = i + 1; j <= s.length(); j++) {

                if (isNumeric(s.substring(i, j))) {
                    continue;
                }
                q1.add(Integer.valueOf(s.substring(i, j - 1)));
                i = j - 1;
                break;
            }
        }
        //System.out.println(q1);
        //System.out.println(q2);

        int sum = q1.poll();
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q2.poll() == '+'){
                sum = sum + q1.poll();
            }else{
                sum = sum - q1.poll();
            }
        }
        return sum;
    }


    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
