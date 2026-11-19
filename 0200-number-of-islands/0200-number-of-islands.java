
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {
                    res++;
                    dfs(grid, i, j, vis, n, m);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int i, int j,
                    boolean[][] vis, int n, int m) {

        // Base conditions
        if (i < 0 || j < 0 || i >= n || j >= m ||
            grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        // Explore all 4 directions
        dfs(grid, i + 1, j, vis, n, m); // Down
        dfs(grid, i - 1, j, vis, n, m); // Up
        dfs(grid, i, j + 1, vis, n, m); // Right
        dfs(grid, i, j - 1, vis, n, m); // Left
    }
}
