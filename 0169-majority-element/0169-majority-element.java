class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> hmap = new HashMap<>();

       for(int i=0; i<nums.length; i++){
        hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
       }

       for(int key: hmap.keySet()){
        if(hmap.get(key)>nums.length/2){
            return key;
        }
       }
       return -1;
    }
}