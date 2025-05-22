import java.util.*;
public class minimumWindowSubstring2 {
    public static String window(String str, String t){
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int x = 0; x < t.length(); x++){
            map.put(t.charAt(x), map.getOrDefault(t.charAt(x), 0)+1);
        }
        int count = map.size();
        while(j<str.length()){
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j)) == 0){
                    count --;
                }
            }

            while(count == 0){
                if(j-i+1 < min){

                    min = j - i+1;
                    start = i;
                }
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                    if(map.get(str.charAt(i)) > 0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? "" : str.substring(start , start+ min);
    }
    public static void main(String[] args) {
        // String str = "ADOBECODEBANC";
        // String t = "ABC";
        String str = "TOTMTAPTAT";
        String t = "TTA";
        System.out.println(window(str, t));
    }
    
}
