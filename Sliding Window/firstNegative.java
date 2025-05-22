
import java.util.*;

public class firstNegative {
    public static ArrayList<Integer> first(int arr[], int k){
        int i=0, j =0 ;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while(j<arr.length){
            //calculation
            if(arr[j] < 0){
                q.add(arr[j]);
            }
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                //calculation -> ans
                if(q.isEmpty()){
                    list.add(0);
                }else{
                    list.add(q.peek());
                }
                // window slide 
                if(!q.isEmpty() && arr[i] == q.peek()){
                    q.poll();
                }
                i++;
                j++ ;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        // int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        // int k = 3 ;
        int arr[] = {-8, 2, 3, -6, 10};
        int k = 2 ;
        System.out.println(first(arr, k));
    }
}
