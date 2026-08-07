class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0; // First pointer traverse from the begining
        int j=nums.length-1; // Second pointer traverse from the end
        int count=0; // track the no. of operations performed

        // Implement binary search
        while(i<j){
            if(nums[i]+nums[j] == k){
                count++;
                i++; // move left pointer forward
                j--; // move right pointer backward
            }
            else if(nums[i]+nums[j] > k){
                j--;
            }
            else{
                i++;
            }
        }
        return count;
    }
}