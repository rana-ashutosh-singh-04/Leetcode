class Solution {

    public boolean dfs(int src,boolean[] vis, ArrayList<ArrayList<Integer>> adj ,Set<Integer> topoSort){

        if(vis[src]==true){
            if(topoSort.contains(src)) return false;
            else return true;
        }
        vis[src]=true;
        for(int neighbour: adj.get(src)){
            boolean cycle = dfs(neighbour,vis,adj,topoSort);
            if(cycle==true)return true;
        }

        topoSort.add(src);
        return false;
    }
    public boolean canFinish(int numCourses, int[][] pre) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

       
      for(int[] edges: pre){
        adj.get(edges[0]).add(edges[1]);
       }
        

        Set<Integer> topoSort = new LinkedHashSet<>();
        boolean vis[] = new boolean[numCourses];

        for(int src =0; src<numCourses; src++){
            if(vis[src]==false){
                boolean cycle = dfs(src, vis,adj,topoSort);
                if(cycle==true)return false;
            }
        }

        return true;
    }
}