package com.ch.practice.dp;

import java.util.List;

public class LeetCode120 {


    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = triangle.get(0).get(0);
                } else {
                    if (j != 0 && j != i) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = (j == 0 ? dp[i - 1][0] : dp[i - 1][j - 1]) + triangle.get(i).get(j);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(dp[m - 1][j], result);
        }
        return result;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = i; j >=0 ; j--) {
                if (i == 0 && j == 0) {
                    dp[j] = triangle.get(0).get(0);
                } else {
                    if (j != 0 && j != i) {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                    } else {
                        dp[j] = (j == 0 ? dp[0] : dp[j - 1]) + triangle.get(i).get(j);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            result = Math.min(dp[j], result);
        }
        return result;
    }
}
