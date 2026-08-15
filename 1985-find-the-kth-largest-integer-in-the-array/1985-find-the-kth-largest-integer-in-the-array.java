class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // int arr[]=new int[nums.length];
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=Integer.parseInt(nums[i]);
        // } // Runtime error

        PriorityQueue<String> minHeap=new PriorityQueue<>((a, b) -> {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }

                return a.compareTo(b);
            });

        for(String num:nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
