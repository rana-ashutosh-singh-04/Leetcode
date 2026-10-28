class Solution {
    HashSet<Integer> hSetA = new HashSet<>();
    HashSet<Integer> hSetB = new HashSet<>();

    public boolean canBeDivideInto2Sets(int idx, int[][] graph){
        Queue<Integer> q = new LinkedList<>();

        q.add(idx);
        hSetA.add(idx);

        while(!q.isEmpty()){
            int currNode = q.remove();
            HashSet<Integer> nextSet;
            HashSet<Integer> currSet;
            if(hSetA.contains(currNode)){
               nextSet = hSetB;
               currSet = hSetA;
            }else{
               nextSet = hSetA;
               currSet = hSetB;
            }
            int arr[] = graph[currNode];

            for(int i=0 ; i<arr.length; i++){
                int curr = arr[i];
                
                if(currSet.contains(curr)){
                 return false;
                }

                if(!hSetA.contains(curr)&&!hSetB.contains(curr)){
                    nextSet.add(curr);
                    q.add(curr);
                }
                
            }
        }
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        for(int i=0; i<n; i++){
            if(!hSetA.contains(i)&& !hSetB.contains(i)){
               if(canBeDivideInto2Sets(i,graph)==false){
                return false;
               }
            }
        }
        return true;
    }
}