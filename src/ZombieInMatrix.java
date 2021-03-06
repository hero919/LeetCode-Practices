import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zeqingzhang on 2/20/17.
 */
public class ZombieInMatrix {
    public int zombie(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0){
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int[] zombie = new int[]{
                            j, i
                    };
                    queue.add(zombie);
                }
            }
        }
        if(queue.isEmpty()){
            return -1;
        }

        int step = 0;
        int width = grid[0].length;
        int height = grid.length;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] top = queue.poll();
                int x = top[0];
                int y = top[1];
                if(x - 1 >= 0 && grid[y][x - 1] != 2 && grid[y][x - 1] == 0){
                    int[] newZobie = new int[]{
                            x - 1, y
                    };
                    grid[y][x - 1] = 1;
                    queue.add(newZobie);
                }

                if(x + 1 <  width && grid[y][x + 1] != 2 && grid[y][x + 1] == 0){
                    int[] newZobie = new int[]{
                            x + 1, y
                    };
                    grid[y][x + 1] = 1;
                    queue.add(newZobie);
                }

                if(y - 1 >= 0 && grid[y - 1][x] != 2 && grid[y - 1][x] == 0){
                    int[] newZobie = new int[]{
                            x , y - 1
                    };
                    grid[y - 1][x] = 1;
                    queue.add(newZobie);
                }

                if(y + 1 < height && grid[y + 1][x] != 2 && grid[y + 1][x] == 0){
                    int[] newZobie = new int[]{
                            x , y + 1
                    };
                    grid[y + 1][x] = 1;
                    queue.add(newZobie);
                }
            }
            step++;
        }

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(grid[j][i] == 1 || grid[j][i] == 2){
                    continue;
                }
                return -1;
            }
        }
        return step - 1;
    }


    public static void main(String[] args){
        int[][] input = new int[][]{
            new int[]{0,1,2,0,0},
                new int[]{1,0,0,2,1},
                    new int[]{0,1,0,0,0}
        };
        ZombieInMatrix z = new ZombieInMatrix();

        System.out.println(z.zombie(input));
    }

}
