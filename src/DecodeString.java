import java.util.Stack;
import java.util.stream.Collector;

/**
 * Created by zeqingzhang on 2/27/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + c - '0';
            }else if(c == '['){
                num.push(k);
                string.push(cur);
                cur = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                StringBuilder temp = cur;
                cur = string.pop();
                for(k = num.pop(); k > 0; k--){
                    cur.append(temp);
                }
            }else{
                cur.append(c);
            }

        }
        return cur.toString();
    }


    public static void main(String[] args){
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString("3[a2[c]]"));
    }
}
