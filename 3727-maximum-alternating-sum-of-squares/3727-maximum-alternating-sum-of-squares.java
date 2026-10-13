import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] absArr = new int[n];
        
        // Step 1: Take absolute values
        for (int i = 0; i < n; i++) {
            absArr[i] = Math.abs(nums[i]);
        }

        // Step 2: Sort in ascending order
        Arrays.sort(absArr);

        // Step 3: Use two pointers to alternate large-small selection
        int left = 0, right = n - 1;
        boolean add = true;
        long score = 0;

        while (left <= right) {
            long val;
            if (add) {
                val = 1L * absArr[right] * absArr[right]; // largest abs → add
                right--;
            } else {
                val = 1L * absArr[left] * absArr[left]; // smallest abs → subtract
                left++;
            }
            score += add ? val : -val;
            add = !add;
        }

        return score;
    }
}
