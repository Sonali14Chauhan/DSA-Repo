class Solution {
    public void solve(char[][] board) {
       int n = board.length;
       int m = board[0].length;
       int i , j;

       for( i=0; i<n;i++){
           if(board[i][0] ==  'O'){
            dfs(board, i, 0 , n, m);
           }
       }
       for( j=0; j<m;j++){
         if(board[0][j] ==  'O'){
            dfs(board, 0, j , n, m);
           }
       } 
       for( i=0; i<n;i++){
          if(board[i][m-1] ==  'O'){
            dfs(board, i, m-1 , n, m);
           }
       } 
       for( j=0; j<m;j++){
         if(board[n-1][j] ==  'O'){
            dfs(board, n-1, j , n, m);
           }
       }

        for ( i = 0; i < n; i++) {
            for ( j = 0; j < m; j++) {
                if(board[i][j] ==  'O'){
                    board[i][j] =  'X';
                }
                else if(board[i][j] ==  '#'){
                    board[i][j] =  'O'; 

                }
            }
        }   
    }

    void dfs(char[][] arr, int i, int j, int n, int m){
        if (i < 0 || j < 0 || i >= n || j >= m  || arr[i][j] != 'O') {
            return;
        }
        arr[i][j] =  '#';

            dfs(arr, i+1, j, n, m);
            dfs(arr, i-1, j, n, m);
            dfs(arr, i, j-1, n, m);
            dfs(arr, i, j+1, n, m);
        
       

    }
}