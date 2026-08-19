 // Optimal Approach Using Prefix Sum & HashMap for Positive & Negative elements

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Prefix sum 0 has occurred once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // We need previous prefix sum = sum - k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Increase frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}