public class maxSumSubarray{
    public static int SumMax(int arr[], int k){
        int i=0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE ;
        while(j < arr.length){
            sum += arr[j];
            if(j - i + 1 < k){
                j++;
            }else if(j - i + 1 == k){
                max = Math.max(sum,max);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 1, 8, 2, 9, 1};
        int k = 3 ;
        System.out.println(SumMax(arr, k));
    }
}