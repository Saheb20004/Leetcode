// Optimal Approach using Merge Sort Algo
// TC   ->  O(n logn)
// SC    ->  O(n)

class Solution {

    public int reversePairs(int[] nums) {
        int n=nums.length;
        int temp[] = new int[n];
        return mergeSortAndCount(nums, temp, 0, n - 1);
    }

    // -----------------------------------------
    // Step - 1 : Divide the array
    // -----------------------------------------
    private int mergeSortAndCount(int nums[], int temp[],  int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            // Count reverse pairs in left half
            count += mergeSortAndCount(nums, temp, low, mid);

            // Count reverse pairs in right half
            count += mergeSortAndCount(nums, temp, mid + 1, high);

            // Count cross reverse pairs
            count += countReversePairs(nums, low, mid, high);

            // Normal merge
            merge(nums, temp, low, mid, high);
        }

        return count;
    }


    // -----------------------------------------
    // Step - 2 : Count Cross Reverse Pairs
    // -----------------------------------------
    private int countReversePairs(int nums[], int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high  &&  nums[left] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }


    // -----------------------------------------
    // Normal Merge
    // -----------------------------------------
    private void merge(int nums[], int temp[], int low, int mid, int high) {

        int left = low;
        int right = mid + 1;
        int k = low;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            }
            else {
                temp[k++] = nums[right++];
            }
        }

        // Remaining left elements
        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        // Remaining right elements
        while (right <= high) {
            temp[k++] = nums[right++];
        }

        // Copy back
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }
}