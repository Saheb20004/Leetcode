        // Approach

// 1. Store each element along with its original index.
// 2. Sort the pairs according to their values.
// 3. In the sorted array, form groups where adjacent
//    values differ by <= limit.
// 4. For every group:
//       a. Extract original indices.
//       b. Sort those indices.
//       c. Assign sorted values to sorted indices.
// 5. Return nums.


import java.util.*;

class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        /*
         * Store:
         * [value, originalIndex]
         *
         * Example:
         * nums = [1, 5, 3, 9]
         *
         * pairs:
         * [1,0], [5,1], [3,2], [9,3]
         */
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        /*
         * Sort according to VALUE.
         *
         * This allows us to identify groups where
         * adjacent values differ by <= limit.
         */
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        /*
         * Process one connected group at a time.
         */
        int start = 0;

        while (start < n) {

            int end = start;

            /*
             * Find all elements belonging to the same group.
             *
             * Important:
             * We compare adjacent sorted values.
             *
             * Example:
             * limit = 3
             *
             * values = [1, 3, 5, 8]
             *
             * 1 -> 3 : difference = 2
             * 3 -> 5 : difference = 2
             * 5 -> 8 : difference = 3
             *
             * Therefore all four belong to the same group.
             */
            while (end + 1 < n &&
                   arr[end + 1][0] - arr[end][0] <= limit) {

                end++;
            }

            /*
             * We now have one complete group:
             *
             * arr[start ... end]
             *
             * Values are already sorted.
             */

            // Collect original indices of this group.
            List<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                indices.add(arr[i][1]);
            }

            /*
             * Sort original indices.
             *
             * To make the final array lexicographically smallest,
             * we should put the smallest value at the smallest index.
             */
            Collections.sort(indices);

            /*
             * arr[start ... end] contains values in sorted order.
             *
             * indices contains original positions in sorted order.
             *
             * Assign smallest value -> smallest index
             * Assign second smallest value -> second smallest index
             * and so on.
             */
            for (int i = 0; i < indices.size(); i++) {

                int originalIndex = indices.get(i);

                nums[originalIndex] = arr[start + i][0];
            }

            /*
             * Move to the next group.
             */
            start = end + 1;
        }

        return nums;
    }
}