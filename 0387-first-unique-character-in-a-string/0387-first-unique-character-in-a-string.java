class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> freq=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
    // freq.getOrDefault(ch,0)+1  ->  used to count how many times each character occurs in a HashMap.
    // freq.getOrDefault(ch, 0) -> "Give me the current count of ch. If ch doesn't exist, give me 0."
            freq.put(ch, freq.getOrDefault(ch,0)+1); 
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(freq.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }
}