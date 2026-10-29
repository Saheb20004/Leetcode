class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }


        // Step 2: Create frequency buckets
        List<Integer>[] buckets = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Place numbers into their frequency buckets
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            buckets[count].add(num);
        }

        // Step 4: Collect k most frequent elements
        int[] ans = new int[k];
        int idx = 0;

        for (int f = n; f >= 1 && idx < k; f--) {
            for (int num : buckets[f]) {
                ans[idx++] = num;

                if (idx == k) {
                    break;
                }
            }
        }

        return ans;
    }
}
