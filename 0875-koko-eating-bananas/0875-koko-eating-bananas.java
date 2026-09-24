class Solution {

    public static boolean isPossible(int[] piles,int h, int speed){
        
        long time = 0;

        for(int pile : piles){
            time+=(pile+speed-1)/speed;
        }

        if(time>h){
            return false;
        }else{
            return true;
        }
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;
        int max = 0;

        for(int i=0; i<piles.length; i++){
            max = Math.max(max,piles[i]);
        }


        while(min<=max){

            int mid = min+(max-min)/2;

            if(isPossible(piles,h,mid)){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }

        return min;
    }
}