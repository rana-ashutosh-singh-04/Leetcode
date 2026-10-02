class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int num0 = 0;
        int num1 = 0;
        for(int i=0; i<nums.length; i++){
            int currElem = nums[i];
            int key = target-currElem;
            if(hmap.containsKey(key)){
                num0 = hmap.get(key);
                num1 = i;
                return new int[]{num0,num1};
            }
            hmap.put(currElem,i);
        }
        return new int[]{};
    }
}