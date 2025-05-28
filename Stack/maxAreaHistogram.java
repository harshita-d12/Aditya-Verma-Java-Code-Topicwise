import java.util.*;
public class maxAreaHistogram {
    public static int[] NSRI(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length - 1; i >= 0 ; i--){
            if(s.isEmpty()){
                res[i] = arr.length;
            }else if(!s.isEmpty() && arr[s.peek()] < arr[i]){
                res[i] = s.peek();
            }else if(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    res[i] = arr.length;
                }else{
                    res[i] = s.peek();
                }
            }
            s.push(i);
        }
        return res ;
    }

    public static int[] NSLI(int arr[]){
        int res[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i =0; i<arr.length; i++){
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
    public static int MAH(int height[]){
        int area = 0, maxArea = 0;
        int right[] = NSRI(height);
        int left [] = NSLI(height);
        int width[] = new int[height.length];
        for(int i=0; i<width.length; i++){
            width[i] = right[i] - left[i] - 1 ;
        }
        for(int i = 0; i<width.length; i++){
            area = width[i] * height[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }
    public static void main(String[] args) {
        // int height[] = {6, 2, 5, 4, 5, 1, 6};
        // int height[] = {3, 5, 1, 7, 5, 9};
        int height[] = {2,1,5,6,2,3};

        int right[] = NSRI(height);
        int left[] = NSLI(height);
        for(int i=0; i<right.length; i++){
            System.out.print(right[i]+" ");
        }
        System.out.println("--------------");
        for(int i=0; i<left.length; i++){
            System.out.print(left[i]+" ");
        }
        System.out.println("--------------");

        System.out.println(MAH(height));
        
    }
    
}
