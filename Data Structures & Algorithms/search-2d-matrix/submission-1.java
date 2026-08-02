class Solution {
    public boolean searchMatrix(int[][] mat, int key) {
        int m = 0;
        int n = mat[0].length - 1;
        while (m <= mat.length - 1 && n >= 0) {
            if (mat[m][n] == key) {
                return true;
            }
            if (key <= mat[m][n]) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
