import java.util.Scanner;

/**
 * Created by zeqingzhang on 1/17/17.
 */
public class ho01 {
    public static void main(String[] args){
        String s = "";
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            s = s + scanner.nextLine();
        }

        System.out.println(s);
    }
}
