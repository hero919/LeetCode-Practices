import java.util.Stack;

/**
 * Created by zeqingzhang on 11/8/16.
 */
public class ImplementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByTwoStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void push(int element) {
        // write your code heres
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        int size = stack1.size();
        for(int i = 0; i < size; i++){
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }

    public int top() {
        // write your code here
        int size = stack1.size();
        for(int i = 0; i < size; i++){
            stack2.push(stack1.pop());
        }
        return stack2.peek();

    }

    public static void main(String[] args){
        ImplementQueueByTwoStacks i = new ImplementQueueByTwoStacks();
        i.push(1);
        i.pop();
        i.push(2);
        i.push(3);
        i.top();
        i.pop();
    }

}
