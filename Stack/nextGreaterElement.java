import java.util.*;
public class nextGreaterElement{
    public static void NGR(int arr[], int res[]){
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length - 1; i >= 0 ;i--){
            if(s.isEmpty()){
                res[i] = -1 ;
            }else if( !s.isEmpty() && s.peek() > arr[i] ){
                res[i] = s.peek();
            }else if( !s.isEmpty() && s.peek() <= arr[i]){
                while(!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = s.peek();
                }
            }
            s.push(arr[i]);
        }
    }
    //GFG Solution
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> s  = new Stack<>();
        for(int i=arr.length - 1; i >= 0; i--){
            if(s.isEmpty()){
                res.add(-1);
            }else if(!s.isEmpty() && s.peek() > arr[i]){
                res.add(s.peek());
            }else if(!s.isEmpty() && s.peek() <= arr[i]){
                while(!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    res.add(-1);
                }else{
                    res.add(s.peek());
                }
            }
            s.push(arr[i]);
        }
        Collections.reverse(res);
        return res ;
        
    }
    public static void main(String[] args) {
        // int arr[] = {1, 3, 0, 0, 1, 2, 4};
        int arr[] = {6, 8, 0, 1, 3};
        int res[] = new int[arr.length];
        NGR(arr, res);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("----------------");
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        
    }
}