import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zeqingzhang on 2/11/17.
 */
public class GenerateParenths {
    public List<String> generateParenthesis(int n){
        if(n==0){
            return new ArrayList<>();
        }

        List<String> list = new LinkedList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }


    public void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max* 2){
            list.add(str);
            return;
        }

        if(open< max){
            backtrack(list, str + "(", open + 1,  close, max);
        }

        if(close < open){
            backtrack(list, str + ")", open , close + 1, max);
        }

    }

    public static void main(String[] args){
        GenerateParenths g = new GenerateParenths();
        System.out.print(g.generateParenthesis(3));
    }
}
