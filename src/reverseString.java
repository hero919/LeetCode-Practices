import java.util.Arrays;
import java.util.Collections;

/**
 * Created by zeqingzhang on 2/1/17.
 */
public class reverseString {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        String[] list = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        String seperator = "";
        for(int i = list.length - 1; i >= 0; i--){
            result.append(seperator + list[i]);
            seperator = " ";
        }
        return result.toString();
    }

    public void reverseWords(char[] s) {

    }

    public static void main(String[] args){
//        String input = "   a   b ";
//        reverseString r = new reverseString();
//        System.out.println(r.reverseWords(input));
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\t";
        System.out.println(input.lastIndexOf("\t"));
        System.out.println(input.length());


    }

}
