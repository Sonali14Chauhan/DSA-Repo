class Solution {
    class Pair{
        int i, j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    boolean valid(int i, int j, int n, int m){
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int time = 0,  fresh =0;

        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                    grid[i][j] = -2;
                }else if(grid[i][j] == 1) fresh++;
            }
        }

        while(!q.isEmpty() && fresh > 0){
            time++;
            int s = q.size();
            while(s > 0){
                Pair p = q.poll();
                int r = p.i;
                int c = p.j; 
                for(int k=0; k<4; k++){
                    int row = r + x[k];
                    int col = c + y[k];
                    if(valid(row, col, n, m) && grid[row][col] == 1){
                        q.add(new Pair(row, col));
                        fresh--;
                        grid[row][col] = -2;
                    }
                }
                s--;
            }
        }

        return fresh > 0 ? -1 : time;
    }
}