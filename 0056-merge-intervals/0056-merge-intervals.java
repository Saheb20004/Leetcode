// TC - O(n logn)
// SC - O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals according to start time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        // Step 2: Add the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 3: Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // Overlapping
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // Non-overlapping
            else {
                ans.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // Add the last interval
        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}