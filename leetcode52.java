import java.util.*;

class Solution {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];

        return backtrack(0, n, col, d1, d2);
    }

    private int backtrack(int row, int n, boolean[] col, boolean[] d1, boolean[] d2) {
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int c = 0; c < n; c++) {
            int x = row - c + n - 1;
            int y = row + c;

            if (col[c] || d1[x] || d2[y]) {
                continue;
            }

            col[c] = true;
            d1[x] = true;
            d2[y] = true;

            count += backtrack(row + 1, n, col, d1, d2);

            col[c] = false;
            d1[x] = false;
            d2[y] = false;
        }

        return count;
    }
}