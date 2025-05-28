import java.util.*;
public class stockSpan {
    public static int[] stock(int arr[]){
        int[] ans = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(s.isEmpty()){
                ans[i] = i+1;
            }else if(!s.isEmpty() && arr[s.peek()] > arr[i]){
                ans[i] = i-s.peek();
            }else if(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    ans[i] = i+1;
                }else{
                    ans[i] = i-s.peek();
                }
            }
            s.push(i);
        }
        return ans;

    }
    public static void main(String args[]){
        // int arr[] = {100, 80, 60, 70, 60, 75, 85};
        int arr[] = {21473, 1489,126474, 2116};
        int ans[] =new int[arr.length];
        ans = stock(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();

    }
}
