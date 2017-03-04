import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 1/12/17.
 */
public class WordSearch02 {
    class Trie{
        String word;
        Trie[] leaves = new Trie[26];
    }



    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board == null || board.length == 0){
            return result;
        }

        Trie root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.leaves[board[i][j] - 'a'] != null){
                    dfs(board, i , j , root, result);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, Trie root, List<String> result){
        Character c = board[i][j];
        if(i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                ||c == '#' ||root.leaves[c - 'a'] == null){
            return;
        }
        root = root.leaves[c - 'a'];
        board[i][j] = '#';
        if(root.word != null){
            result.add(root.word);
            root.word = null;
            return;
        }

        dfs(board, i + 1, j, root, result);
        dfs(board, i - 1, j, root, result);
        dfs(board, i, j + 1, root, result);
        dfs(board, i, j - 1, root, result);
        board[i][j] = c;
    }






    private Trie buildTrie(String[] words){
        if(words == null || words.length == 0){
            return new Trie();
        }
        Trie root = new Trie();
        for(String word : words){
            char[] characters = word.toCharArray();
            Trie start = root;
            for(Character c : characters){
                if(start.leaves[c - 'a'] != null){
                    continue;
                }
                start.leaves[c - 'a'] = new Trie();
                start = start.leaves[c - 'a'];
            }
            //Finish Tag
            start.word = word;
        }
        return root;
    }


    public static void main(String[] args){
        char[][] board = new char[][]{
          "a".toCharArray(),

        };
        String[] words = new String[]{
          "a"
        };

        WordSearch02 w = new WordSearch02();
        System.out.println(w.findWords(board, words));
    }

}
