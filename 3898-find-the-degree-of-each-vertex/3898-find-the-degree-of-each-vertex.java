class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int deg[] = new int[n];
        for(int i=0;i<n; i++){
            int count = 0;

            for(int j=0; j<m; j++){
               if(matrix[i][j]==1){
                   count++;
               } 
            }
            deg[i]= count;
        }
        return deg;
    }
}