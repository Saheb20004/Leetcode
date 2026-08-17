// Brute Force - O(n * n)

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        for (int rotations = 0; rotations < n; rotations++) {

            int sorted[] = new int[n];
            int idx = 0;

            // Take elements from rotations to end
            for (int i = rotations; i < n; i++) {
                sorted[idx++] = nums[i];
            }

            // Take elements from beginning to rotations-1
            for (int i = 0; i < rotations; i++) {
                sorted[idx++] = nums[i];
            }

            // Check if rotated array is sorted
            boolean isSorted = true;

            for (int i = 1; i < n; i++) {
                if (sorted[i - 1] > sorted[i]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }
        }

        return false;
    }
}