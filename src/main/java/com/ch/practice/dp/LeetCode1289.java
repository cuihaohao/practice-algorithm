package com.ch.practice.dp;

public class LeetCode1289 {
    /**
     * 时间复杂度 O(n3)
     */
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0] = grid[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }
        return result;
    }

    /**
     * 仅与上一行的最小值和次小值相关
     * O(n2)
     */
    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int minIndex = -1, secondMinIndex = -1;
        for (int i = 0; i < n; i++) {
            // 更新动规值
            int val = grid[0][i];
            dp[0][i] = val;
            // 更新 minIndex 和 secondMinIndex
            if (val < (minIndex == -1 ? Integer.MAX_VALUE : dp[0][minIndex])) {
                secondMinIndex = minIndex;
                minIndex = i;
            } else if (val < (secondMinIndex == -1 ? Integer.MAX_VALUE : dp[0][secondMinIndex])) {
                secondMinIndex = i;
            }
        }
        for (int i = 1; i < n; i++) {
            int minIndex2 = -1, secondMinIndex2 = -1;
            for (int j = 0; j < n; j++) {
                // 更新动规值
                // 可以选择「最小值」的列选择「最小值」
                if (j != minIndex) {
                    dp[i][j] = dp[i - 1][minIndex] + grid[i][j];
                    // 不能选择「最小值」的列选择「次小值」
                } else {
                    dp[i][j] = dp[i - 1][secondMinIndex] + grid[i][j];
                }
                // 更新 minIndex 和 secondMinIndex
                if (dp[i][j] < (minIndex2 == -1 ? Integer.MAX_VALUE : dp[i][minIndex2])) {
                    secondMinIndex2 = minIndex2;
                    minIndex2 = j;
                } else if (dp[i][j] < (secondMinIndex2 == -1 ? Integer.MAX_VALUE : dp[i][secondMinIndex2])) {
                    secondMinIndex2 = j;
                }
            }
            minIndex = minIndex2;
            secondMinIndex = secondMinIndex2;
        }
        return dp[n - 1][minIndex];
    }
}
