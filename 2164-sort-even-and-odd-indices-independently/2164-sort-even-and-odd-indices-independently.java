class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];

        // Even indices increasing
        for(int i=0; i < n-2; i += 2){
            for(int j=i+2; j < n; j += 2){
                if(nums[i] > nums[j]){
                    swap(nums,i,j);
                }
            }
        }

        // Odd decreasing
        for(int i=1; i < n-2; i += 2){
            for(int j=i+2; j < n; j += 2){
                if(nums[i] < nums[j]){
                    swap(nums,i,j);
                }
            }
        }
        return nums;
    }

    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}