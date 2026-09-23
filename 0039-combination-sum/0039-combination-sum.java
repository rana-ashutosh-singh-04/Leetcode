class Solution {


    public static void getAllCombinations(int[] candidates, int idx, int target,ArrayList<Integer> combin  ,
    List<List<Integer>> ans){

        if(idx==candidates.length || target<0){
            return ;
        }
        if(target==0){
            ans.add(new ArrayList<>(combin));
            return;
        }
        combin.add(candidates[idx]);

        // multiple choice
        getAllCombinations(candidates,idx,target-candidates[idx],combin,ans);
        // exclusion choice
        combin.remove(combin.size()-1);
        getAllCombinations(candidates,idx+1,target,combin,ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<Integer> combin = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        getAllCombinations(candidates,0,target,combin,ans);
        return ans;

    }
}