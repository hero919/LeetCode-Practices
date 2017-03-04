import java.util.Arrays;

/**
 * Created by zeqingzhang on 1/25/17.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0|| rooms[0] == null || rooms[0].length == 0){
            return;
        }
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    bfs(rooms, i, j, 0);
                }
            }
        }
    }



    private void bfs(int[][] rooms, int y, int x, int count){
        if(x < 0 || x >= rooms[0].length || y < 0 || y >= rooms.length){
            return;
        }

        if(rooms[y][x] == -1 || rooms[y][x] == 'X'){
            return;
        }

        int INF = 2147483647;
        if(count < rooms[y][x] || rooms[y][x] == INF){
            rooms[y][x] = count;
        }

        int flag = rooms[y][x];
        rooms[y][x] = 'X';
        bfs(rooms, y + 1, x, count + 1);
        bfs(rooms, y - 1, x, count + 1);
        bfs(rooms, y, x + 1, count + 1);
        bfs(rooms, y, x - 1, count + 1);
        rooms[y][x] = flag;
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        int INF = Integer.MAX_VALUE;
        int[][] input = new int[][]{
            new int[]{INF , -1,  0,  INF},
                new int[]{INF, INF, INF,  -1},
                    new int[]{INF,  -1, INF,  -1},
                        new int[]{0,  -1, INF, INF},
        };
        WallsAndGates w = new WallsAndGates();
        w.wallsAndGates(input);
        System.out.println(Arrays.deepToString(input));
    }
}
