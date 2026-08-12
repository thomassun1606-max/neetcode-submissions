public class Solution {
       public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    /** DFS 淹没岛屿，返回该岛屿的面积 */
    private int dfs(int[][] grid, int i, int j) {
        // 越界 或 遇到水/已访问 → 返回 0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0) {
            return 0;
        }

        // 淹没当前格子（标记为已访问）
        grid[i][j] = 0;

        // 当前格子面积 1 + 四个方向的面积之和
        return 1 + dfs(grid, i + 1, j)
                 + dfs(grid, i - 1, j)
                 + dfs(grid, i, j + 1)
                 + dfs(grid, i, j - 1);
    }
}