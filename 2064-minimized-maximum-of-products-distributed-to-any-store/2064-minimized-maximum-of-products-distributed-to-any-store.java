class Solution {

    public static boolean distributionIsPossible(int n, int[] quantities, int mid){

        int stores = 0;

        for(int q : quantities){

            stores+=(q+mid-1)/mid;

            if(stores>n){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int i=0; i<quantities.length; i++){
            high = Math.max(quantities[i],high);
        }

        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(distributionIsPossible( n, quantities, mid)){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }
}