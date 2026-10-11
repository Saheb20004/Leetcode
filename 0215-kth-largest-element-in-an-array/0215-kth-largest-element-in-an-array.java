
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        // Phase 1: build a min-heap (bottom-up, skipping leaves).
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, n);
        }

        // Phase 2: move the current minimum to the end, shrink the heap.
        // The smallest values pile up on the right, so the array becomes DESCENDING.
        for (int end = n - 1; end > 0; end--) {
            swap(nums, 0, end);
            siftDown(nums, 0, end);    // heap size is now 'end'
        }

        return nums[k-1];
    }
    


    // Push nums[i] down within the first 'size' elements until it is <= both children.
    private void siftDown(int[] nums, int i, int size) {
        while (true) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && nums[left] < nums[smallest]) smallest = left;
            if (right < size && nums[right] < nums[smallest]) smallest = right;

            if (smallest == i) break;

            swap(nums, i, smallest);
            i = smallest;
        }
    }



    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}