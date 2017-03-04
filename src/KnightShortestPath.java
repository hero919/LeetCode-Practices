import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by zeqingzhang on 2/19/17.
 */
public class KnightShortestPath {


    public static int shortestPath02(boolean[][] grid, Point source, Point destination){
        int result = 0;
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return result;
        }

        int height = grid.length;
        int width = grid[0].length;

        boolean [][] tracker = new boolean[grid.length][grid[0].length];
        boolean [][] barrier = new boolean[grid.length][];
        for(int i = 0; i < grid.length; i++){
            barrier[i] = grid[i].clone();
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Point top = queue.poll();
                int x = top.x;
                int y = top.y;
                tracker[y][x] = true;
                if(destination.x == x && destination.y == y){
                    return result;
                }

                if(x + 1 < width && y + 2 < height && tracker[y + 2][x + 1] == false && barrier[y + 1][x] != true){
                    queue.add(new Point(x + 1, y + 2));
                    tracker[y + 2][x + 1] = true;
                }

                if(x - 1 >= 0 && y + 2 < height && tracker[y + 2][x - 1] == false && barrier[y + 1][x] != true){
                    queue.add(new Point(x - 1, y + 2));
                    tracker[y + 2][x - 1] = true;
                }

                if(x + 1 < width && y - 2 >= 0 && tracker[y - 2][x + 1] == false && barrier[y - 1][x] != true){
                    queue.add(new Point(x + 1, y - 2));
                    tracker[y - 2][x + 1] = true;
                }

                if(x - 1 >= 0 && y - 2 >= 0 && tracker[y - 2][x - 1] == false && barrier[y - 1][x] != true){
                    queue.add(new Point(x - 1, y - 2));
                    tracker[y - 2][x - 1] = true;
                }

                if(x + 2 < width && y + 1 < height && tracker[y + 1][x + 2] == false && barrier[y][x + 1] != true){
                    queue.add(new Point(x + 2, y + 1));
                    tracker[y + 1][x + 2] = true;
                }

                if(x - 2 >= 0 && y + 1 < height && tracker[y + 1][x - 2] == false && barrier[y][x - 1] != true){
                    queue.add(new Point(x - 2, y + 1));
                    tracker[y + 1][x - 2] = true;
                }

                if(x + 2 < width && y - 1 >= 0 && tracker[y - 1][x + 2] == false && barrier[y][x + 1] != true){
                    queue.add(new Point(x + 2, y - 1));
                    tracker[y - 1][x + 2] = true;
                }

                if(x - 2 >= 0 && y - 1 >= 0 && tracker[y - 1][x - 2] == false && barrier[y][x - 1] != true){
                    queue.add(new Point(x - 2, y - 1));
                    tracker[y - 1][x - 2] = true;
                }
            }
            result++;
        }

        return -1;
    }


    private int rows;
    private int cols;
    private boolean[][] visited;
    public boolean isValid(int x, int y) {
        if(x < 0 || x >= rows || y < 0 || y >= cols
                || visited[x][y] == true) {
            return false;
        }
        return true;
    }

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        Queue<Point> q = new LinkedList<Point>();

        q.offer(source);
        visited[source.x][source.y] = true;

        int steps = 0;//steps from start point

        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {-1, 1, 1, -1, 2, -2, 2, -2};
        while (q.peek() != null) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                if (p.x == destination.x && p.y == destination.y) {
                    return steps;
                }
                //push all "neighbors" of each node to queue
                for (int j = 0; j < 8; j++) {
                    int _x = p.x + dx[j];
                    int _y = p.y + dy[j];
                    //the grid has to be within range and has 0 in it
                    if (isValid(_x, _y) && grid[_x][_y] == false) {
                        Point newPt = new Point(_x, _y);
                        visited[_x][_y] = true;
                        q.offer(newPt);
                    }
                }

            }
            steps++;
        }
        return -1;

    }


    public static void main(String[] args){
        boolean[][] input = new boolean[3][3];
        input[0][1] = true;

        Point p0 = new Point(2, 0);
        Point p1 = new Point(2, 2);
        KnightShortestPath k = new KnightShortestPath();
        System.out.print(k.shortestPath(input, p0, p1));
    }
}
