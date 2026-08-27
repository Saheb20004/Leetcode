class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums,target);
        int ub = upperBound(nums,target);

        // Edge case
        if(lb == nums.length || nums[lb] != target) {
            return new int[] {-1,-1};
        }
        return new int [] {lb, ub-1};
    }

    // Finding the First Occurence of the Target number
    private int lowerBound(int[] arr, int target) {

        int start=0,end=arr.length-1;
        int ans=arr.length;
        while(start <= end){
            int mid = start+(end-start)/2;
            
            if(arr[mid] >= target) {
                ans = mid;
                end = mid-1;
            }
            
            else{
                start=mid+1;
            }
        }
        return ans;
    }


    // Finding the (Last Occurence+1) index of the Target number
    private int upperBound(int[] arr, int target) {

        int start=0,end=arr.length-1;
        int ans=arr.length;
        while(start <= end){
            int mid = start+(end-start)/2;
            
            if(arr[mid] > target) {
                ans = mid;
                end = mid-1;
            }
            
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}