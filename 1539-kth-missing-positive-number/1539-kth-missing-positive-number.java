// Optimal using binary Search Algo

class Solution {
    public int findKthPositive(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Number of positive integers missing before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                // Not enough missing numbers, so search on the right side
                low = mid + 1;
            } 
            else {
                // We have at least k missing numbers, so search on the left side
                high = mid - 1;
            }
        }
        // low = number of elements before the answer
        // k + low || k + high + 1 gives the kth missing positive number
        return low + k;
    }
}