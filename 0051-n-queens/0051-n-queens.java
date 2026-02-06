class Solution {
    public static void solve(int col, List<String> board, List<List<String>> ans,
                             List<Integer> leftRow, List<Integer> uDiagonal,
                             List<Integer> lDiagonal, int n) {
        if(col==n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row=0;row<n;row++) {
            if(leftRow.get(row)==0 &&
               lDiagonal.get(row+col)==0 &&
               uDiagonal.get(n-1+row-col)==0) {
                char ch[]=board.get(row).toCharArray();
                ch[col]='Q';
                board.set(row,new String(ch));
                leftRow.set(row,1);
                lDiagonal.set(row+col,1);
                uDiagonal.set(n-1+row-col,1);
                solve(col+1,board,ans,leftRow,uDiagonal,lDiagonal,n);
                ch[col]='.';
                board.set(row,new String(ch));
                leftRow.set(row,0);
                lDiagonal.set(row+col,0);
                uDiagonal.set(n-1+row-col,0);
               }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
		ArrayList<String> board=new ArrayList<>(n);
		String s=".".repeat(n);
		for(int i=0;i<n;i++) {
			board.add(s);
		}
		ArrayList<Integer> leftRow=new ArrayList<>(Collections.nCopies(n,0));
		ArrayList<Integer> uDiagonal=new ArrayList<>(Collections.nCopies(2*n-1,0));
		ArrayList<Integer> lDiagonal=new ArrayList<>(Collections.nCopies(2*n-1,0));
		solve(0,board,ans,leftRow,uDiagonal,lDiagonal,n);
		return ans;
    }
}