import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length;
        int start = 1;
        int end = piles[len-1];

        while(start < end){
            int speed = (start+end) / 2;
            int time = 0;
            for (int i = 0; i < len; i++) {
                time += Math.ceil((double)piles[i]/speed);
                if(time > h){
                    start = speed+1;
                    break;
                }
            }
            if(time <= h){
                end = speed;
            }
        }
        return start;
    }
}
