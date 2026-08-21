
// Brute Force Approach

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        // Create 2 Arrays to store EVEN and ODD numbers separately
        int even[]=new int[n/2];
        int odd[]=new int[n/2];

        // Traverse the nums array and store the EVEN and ODD numbers separately
        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                even[j++]=nums[i];
            }
            else{
                odd[k++]=nums[i];
            }
        }

        // Now Rearrange the nums Array by pushing EVEN numbers to even places and ODD numbers to odd places maintaining the insertion order
        int a=0,b=0;
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                nums[i] = even[a++];
            }
            else{
                nums[i] = odd[b++];
            }
        }
        return nums;
    }
}