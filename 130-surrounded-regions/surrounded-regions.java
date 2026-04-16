import java.util.*;

class Pair{
    int i , j;
    Pair(int i , int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: Traverse boundary
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                bfs(i,0,board);
            }
            if(board[i][n-1]=='O'){
                bfs(i,n-1,board);
            }
        }

        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                bfs(0,j,board);
            }
            if(board[m-1][j]=='O'){
                bfs(m-1,j,board);  // ✅ FIXED
            }
        }

        // Step 2: Convert remaining O → X and # → O
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    void bfs(int x, int y, char[][] board){
        int m = board.length;
        int n = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        board[x][y] = '#'; // mark safe

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int i = cur.i;
            int j = cur.j;

            for(int k=0; k<4; k++){
                int nx = i + dx[k];
                int ny = j + dy[k];

                if(nx>=0 && ny>=0 && nx<m && ny<n && board[nx][ny]=='O'){
                    board[nx][ny] = '#';
                    q.add(new Pair(nx,ny));
                }
            }
        }
    }
}