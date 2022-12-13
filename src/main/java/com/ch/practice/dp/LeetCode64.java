package com.ch.practice.dp;

public class LeetCode64 {

    public static void main(String[] args) {
        new LeetCode64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int top = i - 1 >= 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(top, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    int m, n;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] f = new int[m][n];
        int[] g = new int[m * n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    f[i][j] = grid[i][j];
                } else {
                    int bottom = i + 1 < m ? f[i + 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int right = j + 1 < n ? f[i][j + 1] + grid[i][j] : Integer.MAX_VALUE;
                    f[i][j] = Math.min(bottom, right);
                    g[getIdx(i, j)] = bottom < right ? getIdx(i + 1, j) : getIdx(i, j + 1);
                }
            }
        }

        int idx = getIdx(0, 0);
        for (int i = 1; i <= m + n; i++) {
            if (i == m + n) continue;
            int x = parseIdx(idx)[0], y = parseIdx(idx)[1];
            System.out.print("(" + x + "," + y + ") ");
            idx = g[idx];
        }
        System.out.println(" ");

        return f[0][0];
    }

    int[] parseIdx(int idx) {
        return new int[]{idx / n, idx % n};
    }

    int getIdx(int x, int y) {
        return x * n + y;
    }
}
