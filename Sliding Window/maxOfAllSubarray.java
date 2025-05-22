import java.util.*;

public class maxOfAllSubarray {
    public static int[] find(int arr[], int k){
        int i=0, j = 0;
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length - k + 1;
        int ans[] = new int[n];
        while(j<arr.length){
            //calculation
            while(!dq.isEmpty() && dq.peekLast() < arr[j]){
                dq.pollLast();
            }
            dq.offerLast(arr[j]);
            if(j-i+1 <k){
                j++;
            }else if(j-i+1 == k){
                //calculation of ans
                ans[i] = dq.peekFirst();

                //sliding window
                //calculation of arr[i]
                if(arr[i] == dq.peekFirst()){
                    dq.pollFirst();
                }
                i++;
                j++;

            }
        }
        return ans ;
        
    }
    public static void main(String[] args) {
        // int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        // int k = 3 ;
        int arr[] = {1, -1};
        int k = 1 ;
        int ans[] = find(arr, k);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
    
}
