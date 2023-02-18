package dp;

import java.util.*;

//ques: https://www.codingninjas.com/codestudio/problems/house-robber_839733

public class HouseRobber {

    static int f(int[] a, int[] dp, int pos) {

        if (pos >= a.length) return 0;

        if (dp[pos] != -1) return dp[pos];

        int take = a[pos] + f(a, dp, pos + 2);
        int notTake = 0 + f(a, dp, pos + 1);

        return dp[pos] = Math.max(take, notTake);
    }

    public static long houseRobber(int[] valueInHouse) {

        int[] dp1 = new int[valueInHouse.length];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[valueInHouse.length];
        Arrays.fill(dp2,-1);

        int[] t1 = new int[Math.max(valueInHouse.length - 1, 1)];
        int[] t2 = new int[Math.max(valueInHouse.length - 1,1)];

        int pos = 0;

        for (int ele : valueInHouse) {
            if (pos == 0) t1[pos] = ele;
            else if (pos == valueInHouse.length - 1) t2[pos - 1] = ele;
            else {
                t1[pos] = ele;
                t2[pos - 1] = ele;
            }
            pos++;
        }

//        for (int ele : t1) System.out.println(ele);


        return Math.max(f(t1, dp1, 0), f(t2, dp2, 0));

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

//            for (int ele : a) System.out.println(ele);
            System.out.println(houseRobber(a));
        }

    }
}