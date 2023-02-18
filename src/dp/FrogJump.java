package dp;

import java.util.*;

//ques: https://www.codingninjas.com/codestudio/problems/frog-jump_3621012

public class FrogJump {

    static int f(int cur, int[] h, int[] dp) {

        if (cur >= h.length) return -1;
        if (cur == h.length - 1) return 0;

        if (dp[cur] != -1) return dp[cur];

        int first = Integer.MAX_VALUE;
        if (cur + 1 < h.length)
            first = + f(cur + 1, h, dp) + Math.abs(h[cur] - h[cur + 1]);
        int second = Integer.MAX_VALUE;
        if (cur + 2 < h.length)
            second = + f(cur + 2, h, dp) + Math.abs(h[cur] - h[cur + 2]);
        return dp[cur] = Math.min(first, second);
    }

    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[heights.length + 5];
        Arrays.fill(dp, -1);
        return f(0, heights, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) heights[i] = sc.nextInt();
            System.out.println(frogJump(n, heights));
        }
    }
}