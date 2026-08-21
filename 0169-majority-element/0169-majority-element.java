class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int majorEl=0;
        int count=0;
        // 1. Apply Moore's Voting Algo
        for(int i=0;i<n;i++){
            if(count == 0){
                // Assign a mojority el
                majorEl=nums[i];
                count=1;
            }
            else if(nums[i] == majorEl){
                count++;
            }
            else{ // nums[i] != majorEl
                count--;
            }
        }

        // 2. Verification
        int countMajorEl=0;
        for(int i=0;i<n;i++){
            if(nums[i] == majorEl) countMajorEl++;
        }

        if(countMajorEl > n/2) return majorEl;
        // If Does not exist any Majority Element
        return -1;
    }
}