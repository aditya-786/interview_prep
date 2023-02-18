package dp;

import java.util.*;

//ques: https://atcoder.jp/contests/dp/tasks/dp_b

public class KFrogJumps {

    static int f(int[] h, int k, int cur, int[] dp) {

        if (cur >= h.length) return -1;
        if (cur == h.length - 1) return 0;

        if (dp[cur] != -1) return dp[cur];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (cur + i < h.length)
                ans = Math.min(ans, f(h, k, cur + i, dp) + Math.abs(h[cur] - h[cur + i]));
        }
        return dp[cur] = ans;
    }

    static int findMinimumCost(int[] h, int k) {
        int[] dp = new int[h.length + 5];
        Arrays.fill(dp, -1);
        return f(h, k, 0, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] h = new int[n];
        for (int i=0;i<n;i++) h[i] = sc.nextInt();

        System.out.println(findMinimumCost(h, k));
    }
}