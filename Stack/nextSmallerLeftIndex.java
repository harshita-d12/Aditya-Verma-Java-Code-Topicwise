import java.util.*;
public class nextSmallerLeftIndex {
    public static int[] NSLI(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i<arr.length; i++){
            if(s.isEmpty()){
                res[i] = -1;
            }else if(!s.isEmpty() && arr[s.peek()] < arr[i]){
                res[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = s.peek();
                }
            }
            s.push(i);
        }
        return res ;

    }
    public static void main(String[] args) {
        int arr[] = {100,80,60,70,60,75,85};
        int res[] = NSLI(arr);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        
    }
    
}
