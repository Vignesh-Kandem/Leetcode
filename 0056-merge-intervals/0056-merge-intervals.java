class Solution {
    public int[][] merge(int[][] intv) {
         int n = intv.length;
         List<int[]> res = new ArrayList<>();
         Arrays.sort(intv, (a,b)->(a[0]-b[0]));
         int pAt = intv[0][0];
         int pDt = intv[0][1];
         res.add(new int[]{pAt , pDt});
         for(int i = 1;i<n;i++){
              int cAt = intv[i][0];
              int cDt = intv[i][1];
              int last[] = res.get(res.size()-1);
              if(cAt <= pDt) {
                   last[1] = Math.max(last[1] , cDt);
                   pDt = Math.max(last[1] , cDt);
              }
              else {
                   res.add(new int[]{cAt ,cDt});
                   pAt = cAt;
                   pDt = cDt;
              }
         }
         return res.toArray(new int[res.size()][2]);
    }
}