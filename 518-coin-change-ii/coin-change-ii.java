class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
//dp[amt][idx] means: Number of ways to make amt using coins from index idx onwards.
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(amount,coins,0,dp);
        return ans;
    }

    public int solve(int amt, int[] coins, int idx, int[][] dp){
        if(amt == 0){
            return 1;
        }
        if(idx>=coins.length){
            return 0;
        }
        if(amt<0){
            return 0;
        }

        if (dp[amt][idx] != -1) {
            return dp[amt][idx];
        }

        int include = solve(amt-coins[idx], coins, idx, dp);
        int exclude = solve(amt, coins, idx+1, dp);
        int finalAns = include+exclude;
        
        dp[amt][idx] = finalAns;

        return finalAns;
    }
}