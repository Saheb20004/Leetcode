
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n=nums.length;
        int majorEl1 = Integer.MIN_VALUE, count1=0;
        int majorEl2 = Integer.MIN_VALUE, count2=0;

        // 1. Apply extended Boyer Moore's Voting Algo
        for(int i=0;i<n;i++){
            if(count1 == 0 && majorEl2 != nums[i]){
                // Assign a mojority el
                majorEl1=nums[i];
                count1=1;
            }
            else if(count2 == 0 && majorEl1 != nums[i]){
                // Assign a mojority el
                majorEl2=nums[i];
                count2=1;
            }


            else if(nums[i] == majorEl1){
                count1++;
            }
            else if(nums[i] == majorEl2){
                count2++;
            }


            else{ // nums[i] != majorEl
                count1 --;
                count2 --;
            }
        }

        // 2. Verification
        int countMajorEl1=0;
        int countMajorEl2=0;

        for(int i=0;i<n;i++){
            if(nums[i] == majorEl1) countMajorEl1++;
            if(nums[i] == majorEl2) countMajorEl2++;
        }

        if(countMajorEl1 > n/3)  ans.add(majorEl1);
        if(countMajorEl2 > n/3)  ans.add(majorEl2);
        // If Does not exist any Majority Element
        return ans;
    }
}