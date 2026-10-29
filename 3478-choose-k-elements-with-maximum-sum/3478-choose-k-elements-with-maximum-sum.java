class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Store {nums1[i], nums2[i], originalIndex}
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
            arr[i][2] = i;
        }

        // Sort by nums1 in ascending order
        Arrays.sort(arr, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Min heap maintains the largest k nums2 values
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long[] ans = new long[n];
        long sum = 0;

        int i = 0;

        while (i < n) {
            int j = i;

            // Find all elements with the same nums1 value
            while (j < n && arr[j][0] == arr[i][0]) {
                j++;
            }

            // Answer every element in this group BEFORE insertion
            for (int p = i; p < j; p++) {
                ans[arr[p][2]] = sum;
            }

            // Add this group's nums2 values for future groups
            for (int p = i; p < j; p++) {
                int value = arr[p][1];

                pq.offer(value);
                sum += value;

                if (pq.size() > k) {
                    sum -= pq.poll();
                }
            }

            i = j;
        }

        return ans;
    }
}
