# 🔥Longest Substring with At Least K Repeating Characters | Divide & Conquer 🧠 | HashMap | Java ☕

# 💡 Intuition

We need to find the longest substring where every character appears at least k times.

The key observation is:

> 🚨 If a character appears less than k times in the current string, that character cannot be part of any valid substring.

So instead of checking every possible substring, we can use that character as a splitting point. ✂️

For example:
```
s = "aaabbc"
k = 3
```
Frequencies:
```
a → 3 ✅
b → 2 ❌
c → 1 ❌
```
Since b appears fewer than 3 times, no valid answer can contain b.

So we split around b and recursively solve the left and right parts.

# 🚀 Approach
**1️⃣ Base Case**
```
if(s.length() < k || s.isEmpty()) return 0;
```
If the string has fewer than k characters, it is impossible for any character to appear k times.

So the answer is:
```
0️⃣
```
**2️⃣ Count Character Frequencies**

We use a HashMap:
```
Map<Character, Integer> freq = new HashMap<>();
```
Then count every character:
```
for(char ch : s.toCharArray()){
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}
```
For example:
```
s = "aaabbc"

a → 3
b → 2
c → 1
```
**3️⃣ Find an Invalid Character 🚨**

Now we scan the string:
```
if(freq.get(s.charAt(i)) < k)
```
If a character's frequency is less than k, it cannot belong to a valid substring.

Therefore, we split the string around that character:
```
String left = s.substring(0, i);
String right = s.substring(i + 1);
```
Then recursively solve both sides.

**4️⃣ Take the Better Result 🏆**

There can be a valid substring on either side.

So:
```
return Math.max(left, right);
```
We keep whichever side gives the longer valid substring.

# 🔍 Dry Run

Consider:
```
s = "aaabbc"
k = 3
```
Frequency:
```
a → 3 ✅
b → 2 ❌
c → 1 ❌
```
We encounter b, which is invalid.

Split:
```
aaabbc
   ↓
aaa | bc
```
Now solve:
```
"aaa"
```
Every character appears at least 3 times:
```
a → 3 ✅
```
So:
```
answer = 3
```
For:
```
"bc"
```
both characters occur fewer than 3 times, so the answer is 0.

Finally:
```
max(3, 0) = 3
```
🎯 Answer = 3

# 🧠 Why Does This Work?

Suppose:
```
freq['x'] < k
```
Then there aren't enough xs in the entire current string to satisfy the condition.

Therefore, no valid substring of this current string can contain x.

So x becomes a natural boundary:
```
Valid Part | x | Valid Part
```
We can safely solve the two sides independently. 🔥

This is the core Divide & Conquer idea.

# ⚡ Complexity
- **⏱️ Time Complexity:** O(n²) worst case

        At every recursive level, we may scan the current substring and create new substrings.

        In the worst case, the recursion can become highly unbalanced, resulting in approximately:

O(n²)
- **💾 Space Complexity:** O(n)

        The recursion depth can reach O(n) in the worst case.

        The HashMap itself stores at most the number of distinct characters.

# 🎯 Key Takeaway

> 🔥 A character appearing fewer than k times can never belong to a valid substring. Use it as a splitting point and recursively solve the remaining parts.

📌 Pattern to Remember
```
       🔤 Count Frequencies
               ↓
       🚨 Find Invalid Character
               ↓
        Is freq < k ?
          ↙       ↘
        YES        NO
         ↓          ↓
    ✂️ Split      Valid String
       /   \          ↓
      ↓     ↓      Return length
   Left   Right
      \     /
       🏆 MAX
```
Frequency Counting + Divide & Conquer = Clean Recursive Solution 🧠⚡

# Code
```java []
class Solution {
    public int longestSubstring(String s, int k) {
        // Base case
        if(s.length() < k || s.isEmpty()) return 0;
        // 🗺️ Count frequency of every character
        Map<Character,Integer> freq=new HashMap<>();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        // 🔍 Find a character that cannot be part of a valid substring
        for(int i=0;i<s.length();i++){
            if(freq.get(s.charAt(i)) < k){
                // ✂️ Split around the invalid character
                int left=longestSubstring(s.substring(0,i), k);
                int right=longestSubstring(s.substring(i+1), k);
                // 🏆 Take the better side
                return Math.max(left,right);
            }
        }
        return s.length();
    }
}
```
![b455239f478700b4c6bfe395b03c6f99.jpg](https://assets.leetcode.com/users/images/d10bc3a6-6d8d-49da-a0f1-7fc62a469200_1786521887.2591398.jpeg)
![images.jpeg](https://assets.leetcode.com/users/images/61b345e4-146a-4bd9-b40c-09d722ff4f79_1786521893.4109726.jpeg)
