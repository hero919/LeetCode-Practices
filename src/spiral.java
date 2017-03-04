import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 12/1/16.
 */
public class spiral {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null|| matrix[0].length == 0){
            return result;
        }

        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        while(colStart <= colEnd && rowStart <= rowEnd){
            //left to right
            for(int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            //top to bottom
            for(int j = rowStart; j <= rowEnd; j++){
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            //right to left
            for(int k = colEnd; k>= colStart; k--){
                result.add(matrix[rowEnd][k]);
            }

            rowEnd--;

            //bottom to top
            for(int l = rowEnd ; l >= rowStart; l--){
                result.add(matrix[l][colStart]);
            }
            colStart++;
        }
        return result;

    }


    public static void main(String[] args){
        int[] a = new int[]{
                1,2,3
        };
        int[] b = new int[]{
                4,5,6
        };
        int[] c = new int[]{
                7,8,9
        };

        spiral s = new spiral();
        int[][] input = new int[][]{
                a, b, c
        };

        System.out.println(s.spiralOrder(input));


    }

}
