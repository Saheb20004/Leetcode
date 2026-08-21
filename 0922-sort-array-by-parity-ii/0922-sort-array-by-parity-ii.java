
// Optimal Approach

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];

        int evenIdx=0;
        int oddIdx=1;

        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                ans[evenIdx]=nums[i];
                evenIdx += 2;
            }
            else{
                ans[oddIdx]=nums[i];
                oddIdx += 2;
            }
        }
        return ans;
    }
}