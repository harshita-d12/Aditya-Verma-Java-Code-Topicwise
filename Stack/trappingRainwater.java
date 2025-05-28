public class trappingRainwater {
    public static int storedWater(int[] building){
        int size = building.length;
        int maxL[] = new int[size];
        int maxR[] = new int[size];
        maxL[0] = building[0];
        maxR[size-1] = building[size-1];

        for(int i =1; i<size; i++){
            maxL[i] = Math.max(maxL[i-1], building[i]);
        }
        for(int i = size - 2; i >=0; i--){
            maxR[i] = Math.max(maxR[i+1], building[i]);
        }
        int waterLevel[] = new int[size];
        for(int i=0; i<size; i++){
            waterLevel[i] = Math.min(maxL[i], maxR[i]) - building[i];
        }
        int sum = 0 ;
        for(int i = 0; i<size; i++){
            sum+=waterLevel[i];
        }

        return sum ;
    }
    public static void main(String[] args) {
        int building[] = {3, 0, 0, 2, 0, 4};
        System.out.println(storedWater(building));
        
    }
    
}
