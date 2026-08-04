class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean visited[][]=new boolean[n][n];
        pq.offer(new int[]{grid[0][0],0,0});
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!pq.isEmpty()) {
            int current[]=pq.poll();
            int time=current[0];
            int row=current[1];
            int col=current[2];
            if(visited[row][col]) continue;
            visited[row][col]=true;
            if(row==n-1 && col==n-1) return time;
            for(int dir=0;dir<4;dir++) {
                int nr=row+dr[dir];
                int nc=col+dc[dir];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]) {
                    pq.offer(new int[]{Math.max(time,grid[nr][nc]),nr,nc});
                }
            }
        }
        return -1;
    }
}