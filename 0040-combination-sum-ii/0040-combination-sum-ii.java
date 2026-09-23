class Solution {

    public static void getAllCombinations(int[] candidates, int idx , int target, List<Integer> combin, List<List<Integer>> ans){

        if(target==0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        if(idx==candidates.length || target<0){
            return;
        }

        for( int i=idx; i<candidates.length; i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            combin.add(candidates[i]);
            // move forward
            getAllCombinations(candidates,i+1,target-candidates[i], combin,ans);
            combin.remove(combin.size()-1);
        }


    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer>combin = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombinations(candidates,0,target,combin,ans);
        return ans;
    }
}