// Optimal Approach - O(n)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=0;
        for(int i=1;i < n;i++){
            if(nums[k] != nums[i]){
                nums[k+1]=nums[i];
                k++;
            }
        }
        return k+1;
    }
}