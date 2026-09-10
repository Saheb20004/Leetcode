class Solution {

    public int beautySum(String s) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                // Update frequency
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                // Find max and min frequency
                for (int freq : map.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                    minFreq = Math.min(minFreq, freq);
                }
                // Beauty
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }
}