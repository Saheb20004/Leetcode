# Java | Sorting + Two Pointers | O(n log n) Time | Easy Explanation 💁🚀 | Beats 91%🔥

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
To maximize the number of operations, we need to pair two numbers whose sum equals k.

After sorting the array:

* If the current sum is too small, move the left pointer to increase the sum.
* If the current sum is too large, move the right pointer to decrease the sum.
* If the sum equals k, we have found a valid pair. Count the operation and move both pointers.

This greedy approach ensures every element is used at most once while finding the maximum number of valid pairs.
# Approach
<!-- Describe your approach to solving the problem. -->
1. Sort the array.
2. Initialize two pointers:
    * i at the beginning.
    * j at the end.
3. While i < j:
    * If nums[i] + nums[j] == k, increment the operation count and move both pointers.
    * If the sum is greater than k, move the right pointer left.
    * Otherwise, move the left pointer right.
4. Return the total number of operations.
# Complexity
- Time complexity :     O(n log n)
    Sorting takes O(n log n) and the two-pointer traversal takes O(n).
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity :     O(1)
    Ignoring the space used internally by the sorting algorithm.
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0; // First pointer traverse from the begining
        int j=nums.length-1; // Second pointer traverse from the end
        int count=0; // track the no. of operations performed

        // Implement binary search
        while(i<j){
            if(nums[i]+nums[j] == k){
                count++;
                i++; // move left pointer forward
                j--; // move right pointer backward
            }
            else if(nums[i]+nums[j] > k){
                j--;
            }
            else{
                i++;
            }
        }
        return count;
    }
}
```
![752833232_18111680272929361_3080142626387719763_n.jpg](https://assets.leetcode.com/users/images/e5276165-b8bb-4a39-9705-0176a46f4e9d_1786113398.9328046.jpeg)
![images.jpeg](https://assets.leetcode.com/users/images/cee42754-63c0-43cf-9512-dd628d3a42c6_1786113405.280633.jpeg)
