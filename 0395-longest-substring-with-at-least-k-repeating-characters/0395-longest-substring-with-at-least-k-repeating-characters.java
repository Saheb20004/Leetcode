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