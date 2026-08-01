class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) dq.addLast(new int[]{i,j});
                else if(grid[i][j]==1) fresh++;
            }
        } 
        if(fresh==0) return 0;
        int minutes=bfs(m,n,grid,dq,fresh);
        return minutes;
    }
    public int bfs(int m, int n, int[][] grid, ArrayDeque<int[]> dq, int fresh) {
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        int minutes=0;
        while(!dq.isEmpty()) {
            int size=dq.size();
            for(int i=0;i<size;i++) {
                int curr[]=dq.poll();
                int row=curr[0];
                int col=curr[1];
                for(int k=0;k<4;k++) {
                    int nr=row+dr[k];
                    int nc=col+dc[k];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1) {
                        grid[nr][nc]=2;
                        fresh--;
                        dq.addLast(new int[]{nr,nc});
                    }
                }
            }
            if(!dq.isEmpty()) minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}