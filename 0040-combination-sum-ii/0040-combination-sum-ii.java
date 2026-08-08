class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // Sort so that duplicate elements come together
        Arrays.sort(candidates);
        backTrack(0,target,new ArrayList<>(),ans,candidates);

        return ans;
    }


    private void backTrack(int idx,int target,List<Integer> current,List<List<Integer>> ans,int arr[]) {
        // Target reached -> valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try each element starting from idx
        for (int i=idx; i<arr.length; i++) {
            // Skip duplicate elements at the SAME recursion level
            if (i > idx && arr[i] == arr[i-1]) {
                continue;
            }
            // Since array is sorted, no further element can work
            if (arr[i] > target) {
                break;
            }
            // Choose the current element
            current.add(arr[i]);
            // Move to i + 1 because each element can be used ONLY ONCE
            backTrack(i+1, target-arr[i], current, ans, arr);
            // Undo the choice
            current.remove(current.size()-1);
        }
    }
}