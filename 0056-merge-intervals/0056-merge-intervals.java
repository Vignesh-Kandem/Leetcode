class Solution {
    public int[][] merge(int[][] intv) {
        int n=intv.length;
        if(n==0) return new int[0][0];
        Arrays.sort(intv,(a,b)->a[0]-b[0]);
        List<int[]> res=new ArrayList<>();
        res.add(new int[]{intv[0][0], intv[0][1]});
        for(int i=1;i<n;i++){
            int start=intv[i][0];
            int end=intv[i][1];
            int[] last=res.get(res.size()-1);
            if(start<=last[1]){
                last[1]=Math.max(last[1], end);
            }
            else{
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}