class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int inOrder[] = new int[numCourses];

        for(int edges[]: pre){
            adj.get(edges[1]).add(edges[0]);
            inOrder[edges[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(inOrder[i]==0){
                q.add(i);
            }
        }
        int count=0;

        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int edge = q.poll();
            count++;
            res.add(edge);
            for(int neighbour: adj.get(edge)){
                inOrder[neighbour]--;
                if(inOrder[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }

        if(res.size()==numCourses){
        //    int resArr[] = res.toArrays();
        int resArr[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            resArr[i]=res.get(i);
        }
           return resArr;
        }else{
            return new int[]{};
        }


    }
}