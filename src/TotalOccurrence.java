/**
 * Created by zeqingzhang on 10/29/16.
 */
public class TotalOccurrence {
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null||A.length == 0){
            return 0;
        }

        int firstMatchNumber = findFirstEqualNumber(A, target);
        if(firstMatchNumber == -1){
            return 0;
        }
        int count = 0;
        while(firstMatchNumber != A.length && A[firstMatchNumber] == target){
            count++;
            firstMatchNumber++;
        }

        if(firstMatchNumber == A.length){
            return A.length;
        }
        return count;
    }

    private int findFirstEqualNumber(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                end = mid;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(A[start] == target){
            //System.out.println("The start value: " + start);
            return start;
        }

        if(A[end] == target){
            //System.out.println("The end value: " + end);
            return end;
        }

        return -1;
    }

    public static void main(String[] args){
        TotalOccurrence t = new TotalOccurrence();
        System.out.println(t.totalOccurrence(new int[]{1,1,1,1,1,1,1,1,1,1,1}, 1));

    }
}
