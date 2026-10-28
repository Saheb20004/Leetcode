
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;
        // Every card must belong to a complete group
        if (n == 0 || n % groupSize != 0)
            return false;

        // Store card frequencies in sorted order
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        // Always start a group with the smallest unused card
        while (!freq.isEmpty()) {
            int start = freq.firstKey();

            // Try to form a consecutive group
            for (int card = start;
                 card < start + groupSize;
                 card++) {

                // A required consecutive card is missing
                if (!freq.containsKey(card)) {
                    return false;
                }

                // Use one occurrence of this card
                int count = freq.get(card);

                if (count == 1) {
                    freq.remove(card);
                } else {
                    freq.put(card, count - 1);
                }
            }
        }

        return true;
    }
}
