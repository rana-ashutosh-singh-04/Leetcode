class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int inOrder[] = new int[numCourses];

        for(int i=0; i<pre.length; i++){
                adj.get(pre[i][1]).add(pre[i][0]);
                inOrder[pre[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<inOrder.length; i++){
            if(inOrder[i]==0){
                q.add(i);
            }
        }
        int count =0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int neighbour:adj.get(node)){
                inOrder[neighbour]--;

                if(inOrder[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }

        return count  == numCourses;

    }
}