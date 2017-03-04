import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 2/22/17.
 */
public class Fibonacci {
    int[] array = new int[30];
    public int fabonaci(int index){
        if(index == 0){
            return 0;
        }

        if(index == 1){
            return 1;
        }


        int result = fabonaci(index - 1) + fabonaci(index - 2);
        array[index] = result;
        return result;
    }


    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        System.out.println(f.fabonaci(6));
        for(int i = 0; i < f.array.length; i++){
            System.out.print(f.array[i] + " ");

        }
    }




}
