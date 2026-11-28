class Solution {
    class Node{
        int row;
        int col;

        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    class Pair{
        int dist;
        Node node;

        Pair(int dist, Node node){
            this.dist = dist;
            this.node = node;
        }
    }

    int x[] = {1, -1, 0, 0};
    int y[] = {0, 0, 1, -1};

    public int minimumEffortPath(int[][] height) {
      int n = height.length;
      int m = height[0].length;
      int[][] dist = new int[n][m];
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            dist[i][j] = Integer.MAX_VALUE;
        }
      }
      PriorityQueue<Pair> pq = 
                    new PriorityQueue<Pair>((a, b) -> Integer.compare(a.dist, b.dist));
      dist[0][0] = 0;
      pq.add(new Pair(0, new Node(0, 0)));

      while(!pq.isEmpty()){
        Pair p = pq.poll();
            int dis = p.dist;
            int row = p.node.row;
            int col = p.node.col;

            if(dis > dist[row][col]) continue;

            for(int k=0; k<4; k++){
                int r = row + x[k];
                int c = col + y[k];

                if(!valid(r, c, n, m)) continue;

                int absdiff = Math.abs(height[row][col] - height[r][c]);
                int newWt = Math.max(absdiff, dis);

                // Relaxation
                if(newWt < dist[r][c]){
                    dist[r][c] = newWt;
                    pq.add(new Pair(newWt, new Node(r, c)));
                }
            }

        }
        return dist[n-1][m-1];

    }

    boolean valid(int i, int j, int n, int m){
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}