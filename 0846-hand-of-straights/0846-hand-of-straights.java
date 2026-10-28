
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        // Base Case - Every card must belong to a complete group
        if(n == 0 || n % groupSize != 0)    return false;

        // Count the frequency of each card
        Map<Integer, Integer> freq = new HashMap<>();

        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        // Min Heap stores distinct card values in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int card : freq.keySet()) {
            minHeap.offer(card);
        }

        // Form consecutive groups until all cards are used
        while (!minHeap.isEmpty()) {

            // Remove cards that have already been fully used
            while (!minHeap.isEmpty()
                    && freq.get(minHeap.peek()) == 0) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                break;
            }

            // Smallest remaining card must start a group
            int start = minHeap.peek();

            // Check and consume all required consecutive cards
            for (int j = 0; j < groupSize; j++) {
                int card = start + j;

                // Required card is missing or already used
                if (!freq.containsKey(card) || freq.get(card) == 0) {
                    return false;
                }

                // Use one occurrence of this card
                freq.put(card, freq.get(card) - 1);
            }
        }

        return true;
    }
}
