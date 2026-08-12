class Solution {
   public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int count = 0;
    int m = grid.length, n = grid[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                count++;              // 发现新岛屿
                dfs(grid, i, j);      // 淹没整个岛屿
            }
        }
    }
    return count;
}

private void dfs(char[][] grid, int i, int j) {
    // 越界 或 遇到水/已访问 -> 返回
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length 
        || grid[i][j] == '0') return;

    grid[i][j] = '0';  // 淹没当前陆地（原地标记，省 visited 数组）

    // 四方向探索
    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
}
}
