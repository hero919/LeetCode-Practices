/**
 * Created by zeqingzhang on 11/17/16.
 */
public class LongestPalidrome {
//    public String longestPalindrome(String s) {
//        if(s == null || s.length() == 0){
//            return s;
//        }
//
//        String result = Character.toString(s.charAt(0));
//        for(int i = 0; i < s.length(); i++){
//            for(int j = 0; j <= i ; j++){
//                String substring = s.substring(j, i + 1);
//                if(isPalidrome(substring) && result.length() < substring.length()){
//                    result = substring;
//                }
//            }
//        }
//
//        return result;
//
//    }
//
//
//    public boolean isPalidrome(String s){
//        if(s == null || s.length() == 0){
//            return true;
//        }
//        int length = s.length();
//        for(int i = 0 ; i < s.length()/2; i++){
//            if(s.charAt(i) == s.charAt(length - i - 1)){
//                continue;
//            }
//            return false;
//        }
//        return true;
//    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        if(s.length() == 2){
            return (s.charAt(0) == s.charAt(1))? s : s.substring(0,1);
        }

        String result = s.substring(0,1);
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

        String result = "";
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(result.length() < s.substring(start + 1, end).length()){
            result = s.substring(start + 1, end);
        }

        return result;
    }



    public static void main(String[] args){
        LongestPalidrome l = new LongestPalidrome();
        System.out.println(l.longestPalindrome("ccd"));
    }
}
