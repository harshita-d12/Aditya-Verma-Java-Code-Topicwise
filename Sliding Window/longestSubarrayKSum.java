public class longestSubarrayKSum {
    public static int Count(int arr[], int k){
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while(j<arr.length){
            //calculation
            sum += arr[j];
            // sum < k
            if(sum < k){
                j++;
            }
            //sum > k
            else if(sum > k){
                while(sum > k){
                    sum -= arr[i];
                    i++;
                }
                j++;

            }
            //sum == k
            else if(sum == k){
                max = Math.max(j-i+1, max);
                j++;
            }


        }
        return max ;
    }
    public static void main(String[] args) {
        int arr[] = {4,1,1,1,2,3,5};
        int k = 5 ;
        System.out.println(Count(arr, k));
    }
}
