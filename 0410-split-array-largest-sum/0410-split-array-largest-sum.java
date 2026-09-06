// Optimal Using Binary Search

class Solution {
    public int splitArray(int[] nums, int k) {

        if (nums.length < k) {
            return -1;
        }

        long low = 0;
        long high = 0;

        // Find maximum pages in one book
        // and total pages.
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (calculateStudent(nums, mid) <= k) {
                // This capacity is possible.
                // Try to find a smaller capacity.
                high = mid - 1; // eliminate right half
            } else {
                // This capacity is not sufficient.
                // Increase the capacity.
                low = mid + 1; // eliminate left half
            }
        }

        return (int) low;
    }

    private int calculateStudent(int[] arr, long pages) {

        int student = 1;
        long pagesStudentHave = 0;

        for (int i = 0; i < arr.length; i++) {

            if (pagesStudentHave + arr[i] <= pages) {
                pagesStudentHave += arr[i];
            } else {
                student++;
                pagesStudentHave = arr[i];
            }
        }

        return student;
    }
}