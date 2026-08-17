// Approach - O(n * n)

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        // Create a sorted copy
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int rotations = 0; rotations <= n; rotations++) {

            boolean isSorted = true;

            // Compare sorted array with rotated nums
            for (int i = 0; i < n; i++) {

                if (sorted[i] != nums[(i + rotations) % n]) {
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