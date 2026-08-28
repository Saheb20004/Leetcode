// Using Binary Search Algo

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int low = 1, high = n-2;

        // Edge Cases
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        while(low <= high){
            int mid = low+(high-low)/2;
            // Single element is on the mid
            if(nums[mid-1] != nums[mid]    &&   nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            // Single element is on the right half so eliminate the left half
            else if( (mid % 2 == 1   &&   nums[mid] == nums[mid-1]) || 
                    (mid % 2 == 0  &&  nums[mid] == nums[mid+1]) )  { // (even,odd) idices
                        low = mid+1;
            }
            // Single element is on the left half so eliminate the right half
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}