import java.util.HashMap;

public class longestSubstringWithNoRepeatingCharacter {
    public static int find(String str){
        int i= 0, j = 0 ;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < str.length()){
            //calculation
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
            if(map.size() == j-i+1){
                max = Math.max(max, j-i+1);
                j++;
            }else if(map.size() < j-i+1){
                while(map.size() < j-i+1){
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i)) == 0){
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(find(str));

    }
    
}
