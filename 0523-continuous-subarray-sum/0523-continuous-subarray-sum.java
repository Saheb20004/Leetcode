 // Optimal Approach Using Prefix Sum & HashMap for Positive elements only

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Remainder 0 occurs before the array starts
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int rem=sum % k;
            // If Same remainder was seen before
            if (map.containsKey(rem)) {
                int prevIdx = map.get(rem);
                // Subarray length must be at least 2
                if (i - prevIdx >= 2) {
                    return true;
                }

            } 
            else {
                // Store FIRST occurrence only
                map.put(rem, i);
            }
        }
        return false;
    }
}