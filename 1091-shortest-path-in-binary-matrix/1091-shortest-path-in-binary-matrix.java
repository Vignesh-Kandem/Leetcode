class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int dr[]={-1,-1,-1,0,0,1,1,1};
        int dc[]={-1,0,1,-1,1,-1,0,1};
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int dis[][]=new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(dis[i],-1);
        }
        dis[0][0]=1;
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.addLast(new int[] {0,0});
        while(!dq.isEmpty()) {
            int cur[]=dq.removeFirst();
            int r=cur[0];
            int c=cur[1];
            if(r==n-1 && c==n-1) return dis[r][c];
            for(int k=0;k<8;k++) {
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && dis[nr][nc]==-1) {
                    dis[nr][nc]=dis[r][c]+1;
                    dq.addLast(new int[] {nr, nc});
                }
            }
        }
        return -1;
    }
}