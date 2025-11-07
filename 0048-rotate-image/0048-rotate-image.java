class Solution {
    void swap(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    void reverseRow(int arr[][], int row, int n) {
        int p1=0,p2=n-1;
        while(p1<p2) {
            int temp=arr[row][p1];
            arr[row][p1]=arr[row][p2];
            arr[row][p2]=temp;
            p1++;
            p2--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // Transpose the matrix 
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                swap(matrix,i,j);
            }
        }
        // reverse the each row(leads to mirror image)
        for(int i=0;i<n;i++) {
            reverseRow(matrix,i,n);
        }
    }
}