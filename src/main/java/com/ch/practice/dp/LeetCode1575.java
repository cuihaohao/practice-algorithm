package com.ch.practice.dp;

import java.util.Arrays;

public class LeetCode1575 {
    static int[][] cache;

    public static void main(String[] args) {

        System.out.println(new LeetCode1575().countRoutes(new int[]{2,3,6,8,4}, 1, 3, 5));
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        cache = new int[locations.length][fuel + 1];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    public int dfs(int[] locations, int start, int finish, int fuel) {
        int result = 0;
        if (cache[start][fuel] != -1) {
            return cache[start][fuel];
        }
        if (fuel == 0) {
            if (start == finish) {
                cache[start][0] = 1;
                return 1;
            } else {
                cache[start][0] = 0;
                return 0;
            }
        }
        int cost = Math.abs(locations[start] - locations[finish]);
        if (fuel < cost) {
            cache[start][fuel] = 0;
            return 0;
        }

        for (int i = 0; i < locations.length; i++) {
            if (i != start) {
                int need = Math.abs(locations[i] - locations[start]);
                if (need <= fuel) {
                    result += dfs(locations, i, finish, fuel - need);
                    result %= 1000000007;
                }
            }
        }
        int temp = (start == finish ? 1 : 0);
        result += temp;
        cache[start][fuel] = result;
        return result;
    }


}
