class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; i++)
            stones[i] += stones[i - 1];

        int ans = stones[n - 1];
        for (int i = n - 2; i > 0; i--)
            ans = Math.max(ans, stones[i] - ans);

        return ans;
    }
}

// https://leetcode.com/problems/stone-game-viii/solutions/8479069/solution-by-la_castille-g2jy/?envType=daily-question&envId=2026-08-24