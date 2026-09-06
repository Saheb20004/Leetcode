// Optimal using Binary Search approach

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int i=0;i<nums.length;i++){
            high = Math.max(high, nums[i]);
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            if(calculateSum(nums, mid) <= threshold){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    private int calculateSum(int nums[], int mid){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            // Equivalent to Math.ceil( (double) nums[i] / mid)
            sum += (nums[i] + mid - 1) / mid;
        }
        return sum;
    }
}