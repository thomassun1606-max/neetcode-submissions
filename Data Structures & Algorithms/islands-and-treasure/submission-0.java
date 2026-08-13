class Solution {
        // 用 Integer.MAX_VALUE 表示空房间（INF）
    private static final int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][]dir =  new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d: dir){
                int ni = d[0]+cur[0];
                int nj = d[1]+cur[1];
                if(ni<0||ni>=m||nj<0||nj>=n){
                    continue;
                }
                if(grid[ni][nj]==INF){
                    grid[ni][nj]=grid[cur[0]][cur[1]]+1;
                    queue.offer(new int[]{ni,nj});
                }
            }
        }

    }
}
