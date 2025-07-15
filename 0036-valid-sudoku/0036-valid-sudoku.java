class Solution {
    public boolean isValidSudoku(char[][] board) {
       int n = board.length;
        int m = board[0].length;
        HashMap<Integer , Integer> row = new HashMap<>();
        HashMap<Integer , Integer> col = new HashMap<>();
        for(int i = 0; i < n; i++){
            row.clear();
            col.clear();
            for(int j = 0; j < m; j++){
                if(board[i][j] != '.') {
                    int rowNum = board[i][j] - '0';
                    row.put(rowNum, row.getOrDefault(rowNum , 0) + 1);
                    if(row.get(rowNum) > 1) return false;
                }
                if(board[j][i] != '.') {
                    int colNum = board[j][i] - '0';
                    col.put(colNum, col.getOrDefault(colNum , 0) + 1);
                    if(col.get(colNum) > 1) return false;
                }
            }
        }
        HashSet<Integer>[] boxes = new HashSet[9];
        for(int i = 0; i < 9; i++){
            boxes[i] = new HashSet<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int ind = (i / 3) * 3 + (j / 3);
                    if(boxes[ind].contains(num)) return false;
                    boxes[ind].add(num);
                }
            }
        }
        return true;
    }
}