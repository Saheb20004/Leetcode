class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1) sum += nums[i]; // main Logic
            else break;
        }
        
        // Create a HashSet to store the visited values
        Set<Integer> visited = new HashSet<Integer>();
        for(int num : nums){
            visited.add(num);
        }
        int ans=sum;

        // If answer exist in the set then increase it by 1 otherwise directly return the ans
        while(visited.contains(ans)){
            ans++;
        }
        return ans;
    }
}