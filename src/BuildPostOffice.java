//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * Created by zeqingzhang on 2/20/17.
// */
//public class BuildPostOffice {
//    public int shortestDistance(int[][] gridReal) {
//        // Write your code here
//        int result = 0;
//        if(gridReal == null || gridReal.length == 0){
//            return -1;
//        }
//
//        Queue<int[]> TotalQueue = new LinkedList<>();
//        for(int i = 0; i < gridReal.length; i++){
//            for(int j = 0; j < gridReal[0].length; j++){
//                if(gridReal[i][j] == 0){
//                    int[] office = new int[]{
//                            j, i
//                    };
//                    TotalQueue.add(office);
//                }
//            }
//        }
//        if(TotalQueue.isEmpty()){
//            return -1;
//        }
//
//
//
//        int width = gridReal[0].length;
//        int height = gridReal.length;
//
//        int s = TotalQueue.size();
//        for(int j= 0; j < s; j++){
//            int distance = 0;
//            Queue<int[]> queue = new LinkedList<>();
//            queue.add(TotalQueue.poll());
//
//            while(!queue.isEmpty()){
//                int size = queue.size();
//                for(int i = 0; i < size; i++){
//                    int[] top = queue.poll();
//                    int x = top[0];
//                    int y = top[1];
//                    if(x - 1 >= 0 && grid[y][x - 1] != 2 && grid[y][x - 1] == 0){
//                        int[] newZobie = new int[]{
//                                x - 1, y
//                        };
//                        grid[y][x - 1] = 1;
//                        queue.add(newZobie);
//                    }
//
//                    if(x + 1 <  width && grid[y][x + 1] != 2 && grid[y][x + 1] == 0){
//                        int[] newZobie = new int[]{
//                                x + 1, y
//                        };
//                        grid[y][x + 1] = 1;
//                        queue.add(newZobie);
//                    }
//
//                    if(y - 1 >= 0 && grid[y - 1][x] != 2 && grid[y - 1][x] == 0){
//                        int[] newZobie = new int[]{
//                                x , y - 1
//                        };
//                        grid[y - 1][x] = 1;
//                        queue.add(newZobie);
//                    }
//
//                    if(y + 1 < height && grid[y + 1][x] != 2 && grid[y + 1][x] == 0){
//                        int[] newZobie = new int[]{
//                                x , y + 1
//                        };
//                        grid[y + 1][x] = 1;
//                        queue.add(newZobie);
//                    }
//                }
//                distance++;
//            }
//
//            boolean determine = false;
//            for(int i = 0; i < width; i++){
//                for(int z = 0; z < height; z++){
//                    if(grid[z][i] == 1 || grid[z][i] == 2){
//                        continue;
//                    }
//                    determine = true;
//                }
//            }
//
//            if(!determine){
//                result = Math.max(result, distance);
//            }
//        }
//        return result - 1;
//    }
//
//
//
//    public static void main(String[] args){
//        BuildPostOffice b = new BuildPostOffice();
//        int[][] input = new int[][]{
//            new int[]{0,1,0,0,0},
//                new int[]{1,0,0,2,1},
//                    new int[]{0,1,0,0,0}
//        };
//        System.out.println(b.shortestDistance(input));
//    }
//}
