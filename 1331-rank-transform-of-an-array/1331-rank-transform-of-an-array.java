class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Min Heap stores values in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all elements into the heap
        for (int num : arr) {
            minHeap.offer(num);
        }

        // Store the rank of each distinct value
        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;

        // Extract elements from smallest to largest
        while (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();

            // Assign a rank only if this value is new
            if (!rankMap.containsKey(smallest)) {
                rankMap.put(smallest, rank);
                rank++;
            }
        }

        // Replace each element with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}
