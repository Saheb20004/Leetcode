
class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count the frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap: highest frequency comes first
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        // Queue stores {remainingFrequency, availableTime}
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        // Continue until all tasks are completed
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            // Execute the most frequent available task
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;

                // If occurrences remain, put task in cooldown
                if (remaining > 0) {
                    cooldown.offer(
                        new int[]{remaining, time + n + 1}
                    );
                }
            }

            // One CPU interval has passed
            time++;

            // Move tasks back into the heap when cooldown ends
            if (!cooldown.isEmpty()
                    && cooldown.peek()[1] <= time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
