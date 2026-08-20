class Solution {
    public int[] resultArray(int[] nums) {
        int arr1[] = new int[nums.length];
        int arr2[] = new int[nums.length]; 
        // Take two pointer for two diff Arrays
        int n1 = 0;
        int n2 = 0;
        // Assume 0 indexed Array
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                arr1[n1++] = nums[i];
            } 
            else if (i == 1) {
                arr2[n2++] = nums[i];
            } 
            else {
                if (arr1[n1 - 1] > arr2[n2 - 1]) {
                    arr1[n1++] = nums[i];
                } else {
                    arr2[n2++] = nums[i];
                }
            }
        }
        // Append the elements of arr2 to arr1
        for (int i = 0; i < n2; i++) {
            arr1[n1++] = arr2[i];
        }

        return arr1;
    }
}