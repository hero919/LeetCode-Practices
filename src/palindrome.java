import java.util.Stack;

/**
 * Created by zeqingzhang on 11/19/16.
 */
public class palindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return s;
        }
        int size = s.length();
        if(size == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }else{
                return s.substring(0, 1);
            }
        }
        String result = s.substring(0, 1);
        for(int i = 0; i < size; i++){
            String pos1 = getPalindrome(s, i, i);
            String pos2 = getPalindrome(s, i, i + 1);
            String pos = (pos1.length() > pos2.length())? pos1 : pos2;
            result = (result.length() < pos.length())? pos : result;
        }
        return result;

    }



    private String getPalindrome(String s, int start, int end){
        if(s == null || s.length() == 0){
            return s;
        }
        int size = s.length();

        while(start >= 0 && end <= size && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }


    public String longestPalindrome02(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        if(s.length() == 2){
            return (s.charAt(0) == s.charAt(1))? s : s.substring(0,1);
        }

        String result = "";
        for(int i = 0; i < s.length(); i++){
            String pos01 = helper(s, i, i);
            String pos02 = helper(s, i, i+ 1);
            if(pos01.length() > pos02.length()){
                if(result.length() < pos01.length()){
                    result = pos01;
                }
            }else{
                if(result.length() < pos02.length()){
                    result = pos02;
                }
            }
        }

        return result;

    }





    private String helper(String s, int start, int end){
        if(s == null || s.length() == 0){
            return s;
        }


        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        return  s.substring(start + 1, end);
    }

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int size = heights.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i <= size; i++){
            int cur = (i == heights.length)? -1 : heights[i];
            while(!stack.isEmpty() && cur <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                result = Math.max(height * width, result);
            }
            stack.push(i);
        }
        return result;
    }
}



