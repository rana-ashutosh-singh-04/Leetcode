class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }

        int si = 0;
        int ei = nums.length-1;

        while(si<=ei){

             int mid = si + (ei-si) / 2;

            if(mid==0 && nums[0]!=nums[1]){
                return nums[mid];
            }

            if(mid==n-1 && nums[n-1] != nums[n-2]){
                return nums[mid];
            }

            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            if(mid % 2 == 0){
                if(nums[mid-1]==nums[mid]){
                    ei = mid-1;
                }else{
                    si = mid+1;
                }
            }else{
                if(nums[mid-1]==nums[mid]){
                    si = mid+1;
                }else{
                    ei = mid-1;
                }
            }
        }

        return -1;
    }
}