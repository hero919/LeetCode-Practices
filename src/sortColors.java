/**
 * Created by zeqingzhang on 11/11/16.
 */
public class sortColors {
    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while (i <= pr) {
            if (a[i] == 0) {
                swap(a, pl, i);
                pl++;
                i++;
            } else if(a[i] == 1) {
                i++;
            } else {
                swap(a, pr, i);
                pr--;
            }
        }
        System.out.println("i is: " + i);
        System.out.println("pr is: " + pr);
        System.out.println("pl is: " + pl);
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args){
        int[] sample = new int[]{
          0,0,2,2,1,1,1,2,0,1,1,2
        };
        sortColors s = new sortColors();
        s.sortColors(sample);

    }
}
