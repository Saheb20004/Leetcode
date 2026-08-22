// Better Approach - O(n * logn)

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int n=nums.length;
        int currCount=0;
        int lastSmaller=Integer.MIN_VALUE;
        int longest=0;

        for(int i=0;i<n;i++){
            if(nums[i]-1 == lastSmaller){
                currCount ++;
                lastSmaller = nums[i];
            }
            else if(nums[i] == lastSmaller){
                continue;
            }
            else if(nums[i] != lastSmaller){
                lastSmaller=nums[i];
                currCount=1;
            }

            longest = Math.max(currCount, longest);
        }
        return longest;
    }
}