import java.util.*;

public class longestSubstringKUniqueCharacter {
    public static int distinct(String str, int k){
        int i=0, j = 0;
        int max = Integer.MIN_VALUE ;
        HashMap<Character, Integer> map = new HashMap<>();

        while(j<str.length()){
            map.put(str.charAt(j),map.getOrDefault(str.charAt(j), 0)+1);

            if(map.size() <k){
                j++;
            }
            else if(map.size() == k){
                max = Math.max(max, j-i+1);
                j++ ;
            }else if(map.size() > k){
                while(map.size() > k){
                    map.put(str.charAt(i), map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i)) == 0){
                        map.remove(str.charAt(i));
                        
                    }
                    i++;
                }
                if(map.size() == k){
                    max = Math.max(max, j-i+1);
                }
                j++;
            }
            
        }
        return max == Integer.MIN_VALUE ? 0 : max ;

    }
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3 ;
        System.out.println(distinct(str, k));
        
    }
    
}
