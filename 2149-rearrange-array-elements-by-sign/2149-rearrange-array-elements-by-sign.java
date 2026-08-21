// Brute Force Approach

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        // Create 2 Arrays to store '+' and '-' numbers separately
        int pos[]=new int[n/2];
        int neg[]=new int[n/2];

        // Traverse the nums array and store the '+' and '-' numbers separately
        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                pos[j++]=nums[i];
            }
            else{
                neg[k++]=nums[i];
            }
        }

        // Now Rearrange the nums Array by pushing '+' numbers to even places and '-' numbers to odd places maintaining the insertion order
        int a=0,b=0;
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                nums[i] = pos[a++];
            }
            else{
                nums[i] = neg[b++];
            }
        }
        return nums;
    }
}