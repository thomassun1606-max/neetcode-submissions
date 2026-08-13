class Solution {
    public int orangesRotting(int[][] grid) {
        // ================= 在这里写你的代码 =================
        int minutes = 0;
        Queue<int[]> rottenQueue = new LinkedList<int[]>();
        if (grid == null || grid.length == 0) return -1;   // 空网格
        int m = grid.length;
        if (grid[0] == null || grid[0].length == 0) return -1;  // 第一行异常
        int n = grid[0].length;
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            if(grid[i][j]==2){
                rottenQueue.offer(new int[]{i,j});
            }
          }
        }
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int size = rottenQueue.size();
        boolean rotted = false; 
        while(!rottenQueue.isEmpty()){
            int[] cur =  rottenQueue.poll();
            
            for(int[] dir: dirs){
                int i_t = cur[0]+dir[0];
                int j_t = cur[1]+dir[1];
                if(i_t<0||i_t>=m||j_t<0||j_t>=n){
                    continue;
                }
                if(grid[i_t][j_t]==1){
                    grid[i_t][j_t]=2;
                    rotted= true;
                    rottenQueue.offer(new int[]{i_t,j_t});
                }
            }
            size--;
            if(size==0){
               if(rotted){
                minutes++; 
                rotted = false;
               }
               size = rottenQueue.size();
            }
        }
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                minutes=-1;
            }
          }
        }
        return minutes;
    }
}
