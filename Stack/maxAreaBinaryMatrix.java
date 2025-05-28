import java.util.Stack;

public class maxAreaBinaryMatrix {
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

    public static int maxAreaRectangle(int arr[][]){
        int n = arr.length, m = arr[0].length;
        int max = 0 ;
        int ans[] = new int[arr.length];
        for(int j = 0; j<arr[0].length; j++){
            ans[j] = arr[0][j];
        }
        max = MAH(ans);
        for(int i=1; i<n; i++){
            for(int j = 0; j <m; j++){
                if(arr[i][j] == 0){
                    ans[j] = 0;
                }else{
                    ans[j]+=arr[i][j]; 
                }
            }
            max = Math.max(max, MAH(ans));
        }
        return max ;

    }
    public static void main(String[] args) {
        int arr[][] = { {0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0} };
        System.out.print(maxAreaRectangle(arr));
        
    }
    
}
