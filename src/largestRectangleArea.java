/**
 * Created by zeqingzhang on 11/19/16.
 */
import java.util.*;
public class largestRectangleArea {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args){
        largestRectangleArea l = new largestRectangleArea();
        int[] h = new int[]{
                2,1,5,6,2,3
        };

        l.largestRectangleArea(h);
    }
}
