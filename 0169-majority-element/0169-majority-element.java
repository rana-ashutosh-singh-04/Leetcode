class Solution {
    public int majorityElement(int[] nums) {
        // Moore voting Algorithm
        int  candidate = 0; 
        int lead = 0;
        for(int num:nums){
            if(lead==0){
              candidate = num ;
            }
            if(num == candidate){
                lead++;
            }else{
                lead--;
            }
        } return candidate;
    }
}