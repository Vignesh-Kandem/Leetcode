class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++) {
            int edge[]=times[i];
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            graph.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()) {
            int[] node=pq.remove();
            int wt=node[0];
            int vertex=node[1];
            if(wt>dist[vertex]){
                continue;
            }
            for(int[] neib:graph.get(vertex)){
                int newwt=neib[1]+wt;
                if(newwt<dist[neib[0]]){
                    dist[neib[0]]=newwt;
                    pq.offer(new int[]{newwt,neib[0]});
                }
            }
        }
        int max=dist[1];
        for(int i=2;i<dist.length;i++) {
            if(dist[i]>=max){
                max=dist[i];
            }
        }
        if(max!=Integer.MAX_VALUE) return max;
        else return -1;
    }
}