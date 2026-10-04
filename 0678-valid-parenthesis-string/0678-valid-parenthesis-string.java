// Idea: Maintain two values:
// - min = minimum possible number of unmatched (.
// - max = maximum possible number of unmatched (.
// For *:
// - For minimum balance, treat * as ).
// - For maximum balance, treat * as (.

class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            min += s.charAt(i) == '(' ? 1 : -1;
            max += s.charAt(i) == ')' ? -1 : 1;

            if (max < 0) return false;

            min = Math.max(min, 0);
        }

        return min == 0;
    }
}



// Algorithm checkValidString(s):

//     min = 0
//     max = 0

//     for each character ch in s:

//         if ch == '(':
//             min++
//             max++

//         else if ch == ')':
//             min--
//             max--

//         else if ch == '*':
//             min--
//             max++

//         if max < 0:
//             return false

//         min = max(min, 0)

//     return min == 0