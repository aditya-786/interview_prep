package dp;

import java.util.*;

//ques: https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

public class NinjaTraining {

    static int f(int[][] a, int[][] dp, int prev, int pos) {

        if (pos == a.length) {
            return 0;
        }

        if (prev != -1 && dp[pos][prev] != -1) return dp[pos][prev];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (prev != i) {
                ans = Math.max(ans, f(a, dp, i, pos + 1) + a[pos][i] +);
            }
        }
        return dp[pos][prev] = ans;
    }

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n + 5][4];

        for (int[] i : dp) Arrays.fill(i, -1);

        return f(points, dp, 3, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            System.out.println(ninjaTraining(n, a));

        }
    }
}