class Pair{
    int i,j;
    Pair(int i , int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int x,y;

        int time=0;
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            int level=q.size();

            while(level>0){
                Pair currentPair=q.poll();
                x=currentPair.i;
                y=currentPair.j;

                if(y-1>=0 && grid[x][y-1]==1){
                    q.add(new Pair(x,y-1));
                    fresh--;
                    grid[x][y-1]=2;
                }

                if(x-1>=0 && grid[x-1][y]==1){
                    q.add(new Pair(x-1,y));
                    fresh--;
                    grid[x-1][y]=2;
                }

                if(y+1<n && grid[x][y+1]==1){
                    q.add(new Pair(x,y+1));
                    fresh--;
                    grid[x][y+1]=2;
                }

                if(x+1<m && grid[x+1][y]==1){
                    q.add(new Pair(x+1,y));
                    fresh--;
                    grid[x+1][y]=2;
                }
                level--;

            }
            time++;
            
            
        }
        

        if(fresh==0){
            return time;
        }

        return -1;
      
    }
}