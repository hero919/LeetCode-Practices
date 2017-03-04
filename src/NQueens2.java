import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 1/21/17.
 */
public class NQueens2 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        List<Integer> array = new ArrayList<>();
        solve(result, array, n);
        return result;
    }

    private void solve(List<List<String>> result, List<Integer> array, int n){
        if(array.size() == n){
            result.add(draw(array));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!isValid(array, i)){
                continue;
            }
            array.add(i);
            solve(result, array, n);
            array.remove(array.size() - 1);
        }
    }

    private List<String> draw(List<Integer> array){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            StringBuilder s = new StringBuilder();
            int z = array.get(i);
            for(int j = 0; j < array.size(); j++){
                if(j == z){
                    s.append('Q');
                }else{
                    s.append('.');
                }
            }
            result.add(s.toString());
        }
        return result;
    }


    private boolean isValid(List<Integer> array, int i){
        int row = array.size();
        for(int j = 0; j < row; j++){
            if(array.get(j) == i){
                return false;
            }

            if(j + array.get(j) == row + i){
                return false;
            }

            if(j - array.get(j) == row - i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueens2 n = new NQueens2();
        System.out.println(n.solveNQueens(4));
    }

}
