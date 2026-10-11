class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); // Sort in ascending order
        // Reverse the sorting into an descending order
        reverse(nums);

        return nums[k-1];
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}