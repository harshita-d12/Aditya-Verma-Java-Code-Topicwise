import java.util.*;
public class nextSmallerRightIndex {
    public static int[] NSRI(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length - 1; i>=0; i--){
            if(s.isEmpty()){
                res[i] = -1;
            }else if(!s.isEmpty() && arr[s.peek()] < arr[i]){
                res[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    res[i] = -1 ;
                }else{
                    res[i] = s.peek();
                }
            }
            s.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {100,80,60,70,60,75,85};
        int res[] = NSRI(arr);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        
    }
}
