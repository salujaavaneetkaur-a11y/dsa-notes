0/1 KNAPSACK (MEMOIZATION)

What is Memoization
Store answers of already solved subproblems. 
Avoid recomputation.

IDEA (FROM RECURSION)

We already had:

solve(n, W)

Now we just store results in a DP table:

dp[n][W]

CODE (MEMOIZATION)

class Solution{
    public int knapsack(int W, int val[], int wt[])
    {
        int n = val.length;

        int[][] dp = new int[n+1][W+1];

        //initialize with -1 (means not calculated)
        for(int i=0; i<=n; i++){
            for(int j = 0; j <= W; j++){
                dp[i][j] = -1;
            }
        }
        return solve(n, W, val, wt, dp);
    }

    private int solve(int n, int W, int val[], int wt[], int[][]dp){

        //Base case
        if(n == 0 || W == 0){
            return 0; 
        }

        //Step 1: check if already solved
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        //Step 2 : normal recursion logic
        if(wt[n-1] <= W){
            int take = val[n-1] + solve(n-1, W-wt[n-1], val, wt, dp);
            int skip = solve(n-1, W, val, wt, dp);

            return dp[n][W] = Math.max(take, skip);
        } else{
            return dp[n][W] = solve(n-1, W, val, wt, dp);
        }
    }
}

Time Complexity
O(n * W)

Because:

each state (n, W) solved once

Space Complexity

O(n * W)
WHY MEMOIZATION?
Recursion repeats same calls
Memoization stores answers → avoids repetition