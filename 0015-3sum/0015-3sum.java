// Optimal ( 2 pointer Approach )

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums); // Sort the array ascending order

        for(int i=0;i<nums.length-2;i++){

            if(i>0  &&  nums[i] == nums[i-1])
                continue; //Skip duplicate element for i

            int j=i+1; // Pointer 1
            int k=nums.length-1; // Pointer 2

            while(j < k){

                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));

                    while(j<k && nums[j] == nums[j+1]) //Skip duplicates for j
                        j++;

                    while(j<k  &&  nums[k] == nums[k-1]) //Skip duplicates for k
                        k--;

                    //Move the pointers after finding the triplets
                    j++;
                    k--;
                }

                else if(sum < 0){
                    j++;// Sum is less than zero, increment j to increase the sum

                }

                else{
                    k--;// Sum is less than zero, decrement k to decrease the sum
                }
            }
        }
        return ans;
    }
}