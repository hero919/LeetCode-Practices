import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zeqingzhang on 2/6/17.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        if(num==null || num.length==0)
            return "";
        String[] Snum = new String[num.length];
        for(int i=0;i<num.length;i++)
            Snum[i] = num[i]+"";

        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1+str2;
                String s2 = str2+str1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(Snum,comp);
        System.out.println(Arrays.toString(Snum));
        if(Snum[Snum.length-1].charAt(0)=='0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for(String s: Snum)
            sb.insert(0, s);

        return sb.toString();

    }


    public static void main(String[] args){
        LargestNumber l = new LargestNumber();
        System.out.println(l.largestNumber(new int[]{
                3, 30, 34, 5, 0
        }));
    }
}
