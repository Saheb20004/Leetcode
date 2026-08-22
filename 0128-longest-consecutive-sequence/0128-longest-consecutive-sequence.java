// Optimal Approach using Set

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> ans=new HashSet<>();
        // Store all elements
        for(int i : nums){
            ans.add(i);
        }

        int longest=0;

        // Find consecutive sequences
        for(int num : ans){
            // num is the starting point
            if( !ans.contains(num-1) ){
                int currEl = num;
                int countCurrEl = 1;

                 // Count consecutive numbers
                while( ans.contains(currEl + 1) ){
                countCurrEl ++;
                currEl ++;
                }

                longest = Math.max(countCurrEl, longest);
            }
        }
        return longest;
    }
}