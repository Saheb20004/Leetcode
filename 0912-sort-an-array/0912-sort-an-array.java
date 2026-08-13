
class Solution {

    public int[] sortArray(int nums[]) {
        int temp[] = new int[nums.length];
        int l=0;
        int r=nums.length-1;
        mergeSortHelper(nums, l, r, temp);
        return nums;
    }

    private void mergeSortHelper(int nums[], int l, int r, int temp[]) {

        // Base case
        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSortHelper(nums, l, mid, temp);
        mergeSortHelper(nums, mid + 1, r, temp);

        merge(nums, l, mid, r, temp);
    }

    private void merge(int nums[], int l, int mid, int r, int temp[]) {

        int left = l;
        int right = mid + 1;
        int idx = l;

        // Compare both halves
        while (left <= mid && right <= r) {

            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        // Remaining left elements
        while (left <= mid) {
            temp[idx++] = nums[left++];
        }

        // Remaining right elements
        while (right <= r) {
            temp[idx++] = nums[right++];
        }

        // Copy back
        for (int i = l; i <= r; i++) {
            nums[i] = temp[i];
        }
    }
}