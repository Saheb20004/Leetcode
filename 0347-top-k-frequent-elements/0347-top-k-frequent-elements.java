class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap ordered by frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(freq.get(a), freq.get(b))
        );

        // Step 3: Keep only k most frequent elements
        for (int num : freq.keySet()) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract elements
        int[] ans = new int[k];
        int idx = 0;

        while (!pq.isEmpty()) {
            ans[idx++] = pq.poll();
        }

        return ans;
    }
}
