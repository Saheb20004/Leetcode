class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // Remainder 0 exists before the array starts
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            // If remainder is negative
            if (rem < 0) {
                rem += k;
            }
            // Add number of previous occurrences
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            // Increase frequency of current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}