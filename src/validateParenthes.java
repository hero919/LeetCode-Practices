import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zeqingzhang on 11/17/16.
 */
public class validateParenthes {
    public boolean isValidParentheses(String s) {
        // Write your code here
        if(s == null || s.length() == 0){
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() && map.containsValue(s.charAt(i))){
                return false;
            }

            if(stack.isEmpty() || map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
                continue;
            }

            if(!stack.isEmpty() && s.charAt(i) == map.get(stack.peek())){
                stack.pop();
                continue;
            }
            return false;

        }

        return stack.isEmpty();
    }
}
