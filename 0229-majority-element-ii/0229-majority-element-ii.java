// Brute Force - O(n * n)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            int count = 0;

            // Avoid checking the same element again
            if (ans.contains(nums[i])) {
                continue;
            }

            // if(ans.size() == 0 || ans.get(0) != nums[i]) {
            for(int j=0;j<n;j++){     
                if(nums[j] == nums[i]){
                    count ++;
                }
                if(count > n/3){
                    ans.add(nums[j]);
                    break;
                }
                }
                if(ans.size() == 2) break;
            // }
        }
        return ans;
    }
}