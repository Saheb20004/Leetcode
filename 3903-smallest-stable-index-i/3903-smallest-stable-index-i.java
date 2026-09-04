class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int min[] = new int[n];
        
        // Minimum from i to n-1
        min[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i+1]);
        }
        
        // Calculate answer
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max - min[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}