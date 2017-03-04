import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zeqingzhang on 2/25/17.
 */
public class ExpressionAddOperators {
    List<String> operators = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if(num == null || num.length() == 0){
            return list;
        }
        operators.add("+");
        operators.add("-");
        operators.add("*");
        //operators.add("/");
        List<String> operationResult = new ArrayList<>();
        int size = num.length() * 2 - 1;
        insertOperators(num, operationResult, size, 1);
        for(int i = 0; i < operationResult.size(); i++) {
            if (calculate(operationResult.get(i)) == target) {
                list.add(operationResult.get(i));
            }
        }
        return list;
    }



    private void insertOperators(String num, List<String> operationResult, int size, int index){
        if(num.length() == size){
            operationResult.add(num);
            return;
        }

        for(String s : operators){
            String pre = num.substring(0, index);
            String after = num.substring(index);
            String result = pre + s + after;
            insertOperators(result, operationResult, size, index + 2);
        }
    }



    private int calculate(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        Stack<Integer> num = new Stack<>();
        Stack<Character> operators = new Stack<>();




        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-'){
                operators.push(input.charAt(i));
                continue;
            }

            if(input.charAt(i) == '*'){
                int right = Character.getNumericValue(input.charAt(i + 1));
                int left = num.pop();
                int newValue = left * right;
                num.push(newValue);
                i++;
                continue;
            }

            num.push(Character.getNumericValue(input.charAt(i)));
        }


        int size = operators.size();
        for(int i = 0; i < size; i++){
            int right = num.pop();
            int left = num.pop();
            Character c = operators.pop();
            if(c == '+'){
                int newValue = left + right;
                num.push(newValue);
            }

            if(c == '-'){
                int newValue = left - right;
                num.push(newValue);
            }
        }
        return num.pop();
    }


    public static void main(String[] args){
        ExpressionAddOperators e = new ExpressionAddOperators();
        System.out.println(e.addOperators("123", 6));
        String test = "test";
        System.out.println(test.substring(0, 0));
        //System.out.println(test.substring(1, 0));

    }


}
