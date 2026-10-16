class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int outerDegree[] = new int[n+1];
        int innerDegree[] = new int[n+1];
        
        for(int i=0; i<trust.length; i++){
            outerDegree[trust[i][0]]++;
            innerDegree[trust[i][1]]++;
        }

        for(int i=1; i<=n; i++){
            if(outerDegree[i] ==0 && innerDegree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}