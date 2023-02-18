package dp;

import java.util.*;

//ques: https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261

public class MaximumNonAdjacentSum {

    static int f(ArrayList<Integer> a, int pos, int[] dp) {

        if (pos >= a.size()) return 0;

        if (dp[pos] != -1) return dp[pos];

        int take = a.get(pos) + f(a, pos + 2, dp);
        int notTake = 0 + f(a, pos + 1, dp);

        return dp[pos] = Math.max(take, notTake);

    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp,-1);
        return f(nums,0,dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> h = new ArrayList<>();
            for (int i = 0; i < n; i++) h.add(sc.nextInt());
            System.out.println(maximumNonAdjacentSum(h));
        }
    }
}