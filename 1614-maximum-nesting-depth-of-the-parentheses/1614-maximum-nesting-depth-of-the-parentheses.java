class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        int count = 0;
        int maxCount = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if( ch == '(' ){
                st.push(ch);
                count ++;
                maxCount = Math.max(count, maxCount);
            }

            else if( ch == ')' && !st.isEmpty() ){
                st.pop();
                count --;
            }
        }
        return maxCount;
    }
}