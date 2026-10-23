
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count the frequency of each task A-Z
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum task frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count how many tasks have the maximum frequency
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Minimum intervals needed to arrange the most frequent tasks
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;

        // Other tasks may fill idle intervals
        return Math.max(tasks.length, intervals);
    }
}
