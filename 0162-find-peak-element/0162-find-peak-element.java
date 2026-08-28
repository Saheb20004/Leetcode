class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        // Edge cases
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1; //If last element is greater than second last

        int left = 1, right = n-2;       
        while(left <= right){
            int mid = left + (right-left)/2;
            if( nums[mid] > nums[mid-1] && nums[mid+1]<nums[mid] ) return mid;
            else if(nums[mid] < nums[mid+1]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}