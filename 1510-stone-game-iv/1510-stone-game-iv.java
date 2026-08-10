 
 // Dp with Memoization 

class Solution {
    int dp[];
    public boolean winnerSquareGame(int n){
        dp=new int[n+1];
        // -1 means state is not calculated yet
        Arrays.fill(dp, -1);
        return solveForAlice(n);
    }

    private boolean solveForAlice(int n){
        // Base case
        if(n == 0) return false;
        // Memoization -> If Already calculated
        if(dp[n] != -1){
            return dp[n] == 1;
        }

        for(int k=1; k*k <= n;k++){
            // Alice chooses k*k
            // Now Bob has n - k*k
            if(solveForAlice(n- k*k) == false){ // call for Bob (n-k*k)
                dp[n]=1; // Alice can win
                return true;
            } 
        }
        dp[n] = 0;
        return false; // Alice could never win
    }
}