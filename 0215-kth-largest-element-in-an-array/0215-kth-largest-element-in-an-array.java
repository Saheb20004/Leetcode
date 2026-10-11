
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap (default PriorityQueue): root = smallest element in the heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : nums) {
            minHeap.add(x);

            // Keep only the k largest values seen so far.
            // The smallest of k+1 values can't be in the top k, so drop it.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The heap now holds the k largest values;
        // its root is the smallest of them, i.e. the k-th largest overall.
        return minHeap.peek();
    }
}