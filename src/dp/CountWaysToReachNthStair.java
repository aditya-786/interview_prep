package dp;

import java.util.*;

//ques: https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650

public class CountWaysToReachNthStair {

    static int MOD = (int)1e9+7;
    static long f(long cur, long tot, long[] dp) {

        if (cur > tot) return 0;
        if (cur == tot) return 1;

        if (dp[(int) cur] != -1) return dp[(int) cur];

        long first = f(cur + 1, tot, dp) % MOD;
        long second = 0;
        // if (cur + 2 <= tot)
        second = f(cur + 2, tot, dp)%MOD;

        return dp[(int) cur] = (first + second)%MOD;
    }

    public static long countDistinctWayToClimbStair(long nStairs) {
        long[] dp = new long[(int) nStairs+5];
        Arrays.fill(dp, -1L);
        return f(0, nStairs, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long ans = countDistinctWayToClimbStair(N);
        System.out.println(ans);
    }
}