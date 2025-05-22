import java.util.HashMap;

public class countOccurencesOfAnagrams {
    public static int CountAnagrams(String str, String ptr){
        int i=0, j = 0;
        int k = ptr.length();
        int answer =0 ;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int x= 0; x<ptr.length(); x++){
            char ch = ptr.charAt(x);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int count = map.size();
        while(j<str.length()){
            //calculation
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j))==0){
                    count --;
                }
            }
            
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                //calculation -> ans
                if(count == 0){
                    answer ++ ;
                }

                //slide window
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                    if(map.get(str.charAt(i)) == 1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String ptr = "for" ;
        System.out.println(CountAnagrams(str, ptr));
    }
    
}
