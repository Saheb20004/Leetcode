class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[]=s.split(" "); // Create an array of Strings by splitting the words of 's'
        // Base case
        if(words.length != pattern.length()) return false;

        // Maps each pattern character to its corresponding word
        HashMap<Character,String> charToWord=new HashMap<>();
    // Stores words that are already mapped to prevent two different characters from mapping to the same word
        HashSet<String> sameWords=new HashSet<>();

        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=words[i];
            // If this character has already been mapped
            if(charToWord.containsKey(ch)){
        // The mapped word must match the current word Otherwise, the pattern is violated
                if(!charToWord.get(ch).equals(word)) return false;
            }
            else{
        // If the current word is already mapped to another character, we cannot assign it again
                if(sameWords.contains(word)) return false;
                // Create a new character -> word mapping
                charToWord.put(ch,word);
                // Mark this word as already assigned
                sameWords.add(word);
            }
        }
        // All mappings are valid
        return true;
    }
}