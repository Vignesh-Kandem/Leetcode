class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Deque<int[]> dq=new ArrayDeque<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==0) dq.offer(new int[]{i,j});
                else mat[i][j]=-1;
            }
        }
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!dq.isEmpty()) {
            int current[]=dq.poll();
            int row=current[0];
            int col=current[1];
            for(int dir=0;dir<4;dir++) {
                int nr=row+dr[dir];
                int nc=col+dc[dir];
                if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1) {
                    mat[nr][nc]=mat[row][col]+1;
                    dq.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}