import java.util.Arrays;

/**
 * Created by zeqingzhang on 11/5/16.
 */
public class UniquePaths02 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }

        if(obstacleGrid[0] == null || obstacleGrid[0].length == 0){
            return 0;
        }

        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] matrix = new int[row][column];
        for(int r = 0; r < row; r++){
            if(obstacleGrid[r][0] == 1){
                matrix[r][0] = 0;
            }else{
                matrix[r][0] = 1;
            }
        }

        for(int c = 0; c < column; c++){
            if(obstacleGrid[0][c] == 1){
                matrix[0][c] = 0;
            }else{
                matrix[0][c] = 1;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        for(int r = 1; r < row; r++){
            for(int c = 1; c < column; c++){
                if(obstacleGrid[r][c] == 1){
                    matrix[r][c] = 0;
                }else if(matrix[r - 1][c] == 0 && matrix[r][c - 1] == 0){
                    matrix[r][c] = 0;
                }else if(matrix[r - 1][c] == 0){
                    matrix[r][c] = matrix[r][c - 1];
                }else if(matrix[r][c - 1] == 0){
                    matrix[r][c] = matrix[r - 1][c];
                }else{
                    matrix[r][c] = matrix[r - 1][c] + matrix[r][c - 1];
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        return matrix[row - 1][column - 1];
    }

    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        int[] a1 = new int[]{
                0,0,0
        };

        int[] a2 = new int[]{
                0,1,0
        };
        int[] a3 = new int[]{
                0,0,0
        };
        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;

        System.out.println(Arrays.deepToString(matrix));
        UniquePaths02 u = new UniquePaths02();

        u.uniquePathsWithObstacles(matrix);
    }

}
