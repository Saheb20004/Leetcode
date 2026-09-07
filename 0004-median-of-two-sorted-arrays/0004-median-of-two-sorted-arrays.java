// Optimal using Binary Search Algo
// TC   ->  O( min(log n, log m) ),     SC -> O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always perform binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // Number of elements that should be present in the left half
        int leftSize = (m + n + 1) / 2;

        int low = 0;
        int high = m;

        while (low <= high) {

            // Partition nums1
            int mid1 = low + (high - low) / 2;

            // Partition nums2
            int mid2 = leftSize - mid1;

            // Boundary elements
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {

                // Odd total number of elements
                if ((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                // Even total number of elements
                return (Math.max(l1, l2) + (double) Math.min(r1, r2)) / 2.0;
            }

            // l1 is too large
            // Move partition of nums1 to the left
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            // l2 is too large
            // Move partition of nums1 to the right
            else { // l2 > r1
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}