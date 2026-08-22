//       Longest Pattern Match(Optimal) :

// 1. Find breakpoint
// 2. Find successor
// 3. Swap
// 4. Reverse suffix

// TC    ->    O(n)

class Solution {

    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int breakPointIdx = -1;

        // step 1 find breaking point 
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                breakPointIdx=i;
                break;
            }
        }

        //  (Edge Case)
        // if there is no breaking  point (Array is in descending order) 
        if(breakPointIdx == -1){
            reverse(nums, 0); 
            return;
        }

        //          Step 2: Find successor
        // Find the smallest element greater than nums[idx1]
        // Since suffix is decreasing, first greater from right is correct
        for(int i=n-1; i >= breakPointIdx;i--){
            if(nums[i] > nums[breakPointIdx]){
                swap(nums, breakPointIdx ,i);
                break;
            }
        }
        // step 3 reverse the rest right half
        reverse(nums, breakPointIdx+1);
    }


    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

}