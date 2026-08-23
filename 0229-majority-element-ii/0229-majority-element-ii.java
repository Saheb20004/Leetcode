
//  Better Approach using HashMap
// Traverse the array.
// Store each element's frequency in the map.
// If any element's frequency becomes greater than n / 2, return it.


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n / 3 && !ans.contains(num)) {
                ans.add(num);
            }
            if(ans.size() == 2) break;
        }

        return ans;
    }
}