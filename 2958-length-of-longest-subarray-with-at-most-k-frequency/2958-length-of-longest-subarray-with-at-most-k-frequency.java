class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // Store the freq of every element in the nums array
        Map<Integer,Integer> freq=new HashMap<>();
        int left=0;
        int right=0;
        int ans=0;
       
       // ➡️ Expand the window using right pointer
        for(right=0;right<nums.length;right++){
            // Add current element to the window
            freq.put( nums[right], freq.getOrDefault(nums[right],0)+1 );
        // ❌ Window is invalid if current element appears > k times
            while(freq.get(nums[right]) > k){
                // Remove leftmost element
                freq.put( nums[left], freq.get(nums[left])-1 );
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }
        // 🏆 Update maximum valid window length
        return ans;
    }
}