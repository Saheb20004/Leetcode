class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        int n=nums.length;

        for(int i=0;i<n;i++){
            HashSet<Integer> visited = new HashSet<>();

            for(int j=i+1;j<n;j++){

                int thirdEl = -(nums[i] + nums[j]);

                    if (visited.contains(thirdEl)) {
                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(thirdEl);
                    // Sort & add the list into a Set to avoid storing duplicate list
                        Collections.sort(list);
                        set.add(list);
                    }
                    visited.add(nums[j]);
                }
            }

        ans.addAll(set);
        return ans;
    }
}