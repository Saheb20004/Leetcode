class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        for(int num : nums){
            // Update the smallest number
            if (num <= min1) {
                min1 = num;
            }
            // Update the second smallest number
            else if (num <= min2) {
                min2 = num;
            }
            // Found a number greater than both
            else {
                return true;
            }
        }

        return false;
    }
}