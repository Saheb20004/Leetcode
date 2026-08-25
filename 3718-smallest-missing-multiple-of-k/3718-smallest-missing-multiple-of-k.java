class Solution {
    public int missingMultiple(int[] nums, int k) {
        for(int minMultiple = k; ; minMultiple += k){
            boolean found=false;

            for(int i=0; i<nums.length; i++){
                if(nums[i] == minMultiple){
                    found=true;
                    break;
                }
            }

            if(!found){
                return minMultiple;
            }

        }
        
    }
}