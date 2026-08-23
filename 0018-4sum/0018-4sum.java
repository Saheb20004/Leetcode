
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                HashSet<Long> visited = new HashSet<>();
                for(int k=j+1;k<n;k++){
                        long fourthEl = (long) target
                                            - nums[i]
                                            - nums[j]
                                            - nums[k];
                                        
                        if( visited.contains(fourthEl) ){
                            List<Integer> list = new ArrayList<>();

                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add((int)fourthEl);
                        // Sort & add the list into a Set to avoid storing duplicate list
                            Collections.sort(list);
                            set.add(list);
                        }
                    visited.add( (long) nums[k]);
                }
            }
        }

        ans.addAll(set);
        return ans;
    }
}