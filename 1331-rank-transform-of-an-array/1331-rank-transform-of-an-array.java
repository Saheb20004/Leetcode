
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        // Create a copy to preserve the original element order
        int[] sorted = arr.clone();

        // Sort values in ascending order
        Arrays.sort(sorted);

        // Map each distinct value to its rank
        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;

        for (int i = 0; i < n; i++) {

            // Assign a rank only to new distinct values
            if (!rankMap.containsKey(sorted[i])) {
                rankMap.put(sorted[i], rank);
                rank++;
            }
        }

        // Replace each original value with its rank
        for (int i = 0; i < n; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}
