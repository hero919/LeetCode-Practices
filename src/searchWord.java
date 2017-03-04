///**
// * Created by zeqingzhang on 11/7/16.
// */
//public class searchWord {
//    public class Solution {
//        /**
//         * @param board: A list of lists of character
//         * @param word: A string
//         * @return: A boolean
//         */
//        public boolean exist(char[][] board, String word) {
//            // write your code here
//            if(board == null || board.length == 0){
//                return false;
//            }
//
//            if(board[0] == null || board[0].length == 0){
//                return false;
//            }
//
//            if(word == null || word.length() == 0){
//                return true;
//            }
//
//            char start = word.charAt(0);
//            int n = board.length;
//            int m = board[0].length;
//            List<List<Integer>> poss = new ArrayList<>();
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < m; j++){
//                    if(board[i][j] == start){
//                        List<Integer> array = new ArrayList<>();
//                        array.add(i);
//                        array.add(j);
//                        poss.add(array);
//                    }
//                }
//            }
//
//            if(poss.size() == 0){
//                return false;
//            }
//
//
//            for(List<Integer> array : poss){
//                if(dfs(array.get(0), array.get(1), board, word, 0)){
//                    return true;
//                }
//            }
//
//            return false;
//
//        }
//
//
//        private boolean dfs(int i, int j,char[][] board, String word, int tracker){
//            boolean result = false;
//            if(i <=0 || i >= board.length - 1|| j <=0 || j >= board[0].length ){
//                return false;
//            }
//            if(board[i][j] == word.charAt(tracker)){
//
//                char temp = board[i][j];
//                board[i][j] = '#';
//                result =  dfs(i + 1, j, board, word, tracker + 1) ||
//                        dfs(i, j + 1, board, word, tracker + 1) ||
//                        dfs(i - 1, j, board, word, tracker + 1) ||
//                        dfs(i, j - 1, board, word, tracker + 1);
//                board[i][j] = temp;
//            }
//
//            if(tracker == word.length()){
//                return true;
//            }
//
//
//            return result;
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//}
