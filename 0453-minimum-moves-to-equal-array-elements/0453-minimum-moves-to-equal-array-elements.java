class Solution {
    public int minMoves(int[] nums) {
        // int low = Arrays.stream(nums).min().getAsInt();
        int low = nums[0];
        for(int i = 0; i < nums.length; i++){
            low = Math.min(nums[i], low);
        }
        int moves = 0;
        for (int x : nums) 
            moves += x - low;
        return moves;
    }
}