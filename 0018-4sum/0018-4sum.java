// Optimal ( 2 pointer Approach )

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;

        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums); // Sort the array ascending order

        for(int i=0;i<n-3;i++){

            if(i>0  &&  nums[i] == nums[i-1])
                continue; //Skip duplicate element for i

            for(int j=i+1; j < n-2; j++){

                if(j != i+1  &&  nums[j] == nums[j-1])
                    continue; //Skip duplicate element for j

                int k=j+1; // Pointer 1
                int l=nums.length-1; // Pointer 2

                while(k < l){

                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if( sum == target ){ // Java will safely compare long with int.
                        ans.add( Arrays.asList(nums[i],nums[j],nums[k],nums[l]) );

                        while(k < l && nums[k] == nums[k+1]) //Skip duplicates for k
                            k++;

                        while(k < l  &&  nums[l] == nums[l-1]) //Skip duplicates for l
                            l--;

                        //Move the pointers after finding the quadruplets
                        k++;
                        l--;
                    }

                    else if(sum < target){
                        k++;// Sum is less than zero, increment k to be close to the target

                    }

                    else{
                        l--;// Sum is less than zero, decrement l to be close to the target
                    }

                }
            }
        }

        return ans;
    }
}