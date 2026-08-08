# 🔥 Combination Sum II | 🧩 Backtracking + Sorting | 🚀 Java | Unique Combinations | Beats 99%🔥

# 🧠Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
We need to find all unique combinations of numbers that add up to target.

The important difference from Combination Sum is:

* Each element can be used only once.
* The input may contain duplicate values.
* The answer must not contain duplicate combinations.

To handle duplicates efficiently, we first sort the array. This puts equal elements next to each other, allowing us to skip duplicates during backtracking.
# 🚀Approach
<!-- Describe your approach to solving the problem. -->
# 1️⃣ Sort the array
`Arrays.sort(candidates);`

Sorting helps us:

* Keep duplicate values together.
* Easily skip duplicate choices.
* Stop early when arr[i] > target.
# 2️⃣ Use Backtracking

We recursively build a combination.

At every step:

- Choose an element.
- Reduce the target.
- Continue with the next index.
- Undo the choice and try another element.
` backTrack(i + 1, target - arr[i], current, ans, arr);`

We use i + 1 because each element can be used only once.

# 3️⃣ Handle duplicates

This is the most important part:

```
if (i > idx && arr[i] == arr[i - 1]) {
    continue;
}
```

This skips duplicate values at the same recursion level.

For example:

``[1, 1, 2]``

At the same level, we don't want to start one combination with the first 1 and another identical combination with the second 1.

But duplicates are still allowed at different recursion levels when they represent different elements.

# 4️⃣ Stop early

Because the array is sorted:

```
if (arr[i] > target) {
    break;
}
```

If the current number is already greater than the remaining target, all following numbers will also be greater.

So there is no need to continue searching.

# 5️⃣ Target becomes zero

When:

```
target == 0

```

we have found a valid combination.

```
ans.add(new ArrayList<>(current));
```

We create a new list because current will continue changing during backtracking.

# 🔍 Example

For:

```
candidates = [10,1,2,7,6,1,5]
target = 8
```

After sorting:

``[1,1,2,5,6,7,10]``

Possible valid combinations are:
```
[1,1,6]
[1,2,5]
[1,7]
[2,6]
```
The duplicate 1 is handled using:
```
if (i > idx && arr[i] == arr[i - 1]) {
    continue;
}
```
So we don't generate duplicate combinations.

This problem is very similar to Combination Sum, but there are two important differences.

# 🔄 Comparison with Combination Sum

**In Combination Sum:**
- An element can be used multiple times.
- We use the same index again during recursion:
```
backTrack(i, target - arr[i], current, ans, arr);
```
**In Combination Sum II:**

- Each element can be used only once.
- Therefore, after choosing arr[i], we move to the next index:
```
backTrack(i + 1, target - arr[i], current, ans, arr);
```
***🧩 Handling Duplicates***

Unlike Combination Sum, this problem can contain duplicate elements, and we need unique combinations.

So, we first sort the array:
```
Arrays.sort(candidates);
```
This puts duplicate values next to each other.

Then, at the same recursion level, we skip duplicate elements:
```
if (i > idx && arr[i] == arr[i - 1]) {
    continue;
}
```
This prevents generating the same combination more than once.

**✂️ Pruning**

Because the array is sorted, if:
```
arr[i] > target
```
then every element after i will also be greater than target.

So we can stop the loop:
```
if (arr[i] > target) {
    break;
}
```
**🔙 Backtracking**

The overall process remains the same as Combination Sum:

**Choose → Explore → Undo**
```
current.add(arr[i]);
backTrack(i + 1, target - arr[i], current, ans, arr);
current.remove(current.size() - 1);
```
So, the main changes from Combination Sum are:

| Combination Sum            | Combination Sum II                        |
| -------------------------- | ----------------------------------------- |
| Element can be reused      | Element used only once                    |
| `backTrack(i, ...)`        | `backTrack(i + 1, ...)`                   |
| No need to skip duplicates | Skip duplicates at same level             |
| Sorting not necessary      | Sorting helps handle duplicates & pruning |

# In short:
 We use the same backtracking idea as Combination Sum, but change the recursive index to i + 1 and add duplicate handling after sorting.
# ⏱️Complexity

* Time Complexity: O(2^n) — In the worst case, the backtracking algorithm may explore many possible subsets.

* Space Complexity: O(n) — The recursion stack and the current combination can contain up to n elements, excluding the space required to store the final answer.

# 🎯 Key Takeaways

* 🔹 Sorting helps handle duplicates.
* 🔹 Backtracking explores all possible combinations.
* 🔹 i + 1 ensures each element is used only once.
* 🔹 i > idx prevents duplicate combinations at the same level.
* 🔹 arr[i] > target provides useful pruning.
* 🔹 current.remove(...) performs the backtracking step.
# Code
```java []
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // Sort so that duplicate elements come together
        Arrays.sort(candidates);
        backTrack(0,target,new ArrayList<>(),ans,candidates);

        return ans;
    }


    private void backTrack(int idx,int target,List<Integer> current,List<List<Integer>> ans,int arr[]) {
        // Target reached -> valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try each element starting from idx
        for (int i=idx; i<arr.length; i++) {
            // Skip duplicate elements at the SAME recursion level
            if (i > idx && arr[i] == arr[i-1]) {
                continue;
            }
            // Since array is sorted, no further element can work
            if (arr[i] > target) {
                break;
            }
            // Choose the current element
            current.add(arr[i]);
            // Move to i + 1 because each element can be used ONLY ONCE
            backTrack(i+1, target-arr[i], current, ans, arr);
            // Undo the choice
            current.remove(current.size()-1);
        }
    }
}
```
![80c1d07e878a8f460cbe2eabdd0855eb.jpg](https://assets.leetcode.com/users/images/3ca40c00-378f-4157-8ec8-7f97b0cc473c_1786202253.2378435.jpeg)
![images.jpeg](https://assets.leetcode.com/users/images/5dbfaad3-9561-4c0e-9e1f-1c9437660a6c_1786202260.7393093.jpeg)
