// Optimal Approach - 2 (Java — Kadane-style approach)

// Approach: Use a modified Kadane's Algorithm. Maintain two variables, maxProd and minProd, representing the maximum and minimum product of a subarray ending at the current index. We maintain both because multiplying by a negative number can convert the minimum negative product into the maximum positive product. For every element, calculate the new maximum and minimum by considering the element itself, its product with the previous maximum, and its product with the previous minimum. Finally, keep track of the maximum value obtained as the answer.

// maxProd = maximum product ending at current index
// minProd = minimum product ending at current index

// Time Complexity  → O(n)
// Space Complexity → O(1)


class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Important: save old values before updating
            int tempMax = maxProd;

            maxProd = Math.max( nums[i],
                Math.max(nums[i] * maxProd, nums[i] * minProd)
            );

            minProd = Math.min( nums[i],
                Math.min(nums[i] * tempMax, nums[i] * minProd)
            );

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}