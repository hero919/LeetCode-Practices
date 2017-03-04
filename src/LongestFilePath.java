import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zeqingzhang on 2/3/17.
 */
public class LongestFilePath {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }

    public static void main(String[] args){
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        String input02 = "\t\tfile.ext";
        LongestFilePath l = new LongestFilePath();
        System.out.println(input.lastIndexOf("Hello"));
    }
}
