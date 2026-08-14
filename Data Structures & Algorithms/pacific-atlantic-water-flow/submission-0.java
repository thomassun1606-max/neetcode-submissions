class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
                int m = heights.length;
        int n = heights[0].length;
        int[][] Pac = new int[m][n];
        int[][] Alt = new int[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i, 0, Pac, heights);
        }
        for (int j = 0; j < n; j++) {
            bfs(0, j, Pac, heights);
        }
        for (int i = 0; i < m; i++) {
            bfs(i, n-1, Alt, heights);
        }
        for (int j = 0; j < n; j++) {
            bfs(m-1, j, Alt, heights);
        }
    List<List<Integer>> resultList =  new ArrayList<List<Integer>>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(Pac[i][j]==1&&Alt[i][j]==1){
                    resultList.add(Arrays.asList(i, j));
                }
            }
        }
    return resultList;
    }
    int[][]dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    private void bfs(int i, int j, int[][] pac, int[][] heights) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        pac[i][j]=1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int i_cur = cur[0];
            int j_cur = cur[1];
            for(int[] dir: dirs){
                int m = dir[0]+i_cur;
                int n = dir[1]+j_cur;
                if (m < 0 || m >= heights.length || n < 0 || n >= heights[0].length) continue;
                if(pac[m][n]==0 && heights[m][n]>=heights[i_cur][j_cur]){
                   pac[m][n]=1;
                   queue.offer(new int[]{m,n});
                }
            }
        }
    }
}
