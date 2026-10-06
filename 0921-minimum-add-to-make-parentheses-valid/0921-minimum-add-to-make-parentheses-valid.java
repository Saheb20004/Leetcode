class Solution {
    public int minAddToMakeValid(String s) {
        int count1 = 0; // for open parenthesis
        int count2 = 0; // for closed parenthesis

        for(int i = 0 ;i < s.length();i ++){
            char ch = s.charAt(i);

            if(ch == '('){
                count1 ++;
            }
            else{ // ch == ')'
                if(count1 > 0){
                    count1 --;
                }
                else{
                    count2 ++;
                }
            }
        }
        return count1 + count2;
    }
}