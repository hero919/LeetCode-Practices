import java.util.Arrays;

/**
 * Created by zeqingzhang on 12/28/16.
 */
public class spiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int tracker = 0;
        int[][] result = new int[n][n];
        while(tracker < n * n){
            for(int i = colStart; i <= colEnd; i++){
                result[rowStart][i] = ++tracker;
            }
            rowStart++;

            for(int i = rowStart; i <= rowEnd; i++){
                result[i][colEnd] = ++tracker;
            }
            colEnd--;

            for(int i = colEnd; i >= colStart; i--){
                result[rowEnd][i] = ++tracker;
            }
            rowEnd--;

            for(int i = rowEnd; i >= rowStart; i--){
                result[i][colStart] = ++tracker;
            }
            colStart++;
        }
        return result;
    }

    public static void main(String[] args){
        spiralMatrix2 s = new spiralMatrix2();



            int temp = 0;
        System.out.println(('e' - 'a'));
        System.out.println(1 << 5);
            System.out.println(temp |= 1 << ('e' - 'a'));
            //System.out.println(temp |= 1 << ('g'));

    }

}
