class Solution {
    // pseudo code
    // 1> Pivot
    // 2> nextSuccessor
    // 3> swap
    // 4> reverseNum
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i]>nums[i-1]){
            pivot = i-1;
            break;
            } 
        }

        if(pivot != -1){
            for(int i=nums.length-1; i>pivot; i--){
                if(nums[pivot]<nums[i]){
                    // swap
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
             reverseNum(nums, pivot+1, nums.length-1);
            
        }else{
            reverseNum(nums,0,nums.length-1);
        }
    }

    private static void reverseNum(int nums[], int left, int right){
      while(left<right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
      }
    }
}