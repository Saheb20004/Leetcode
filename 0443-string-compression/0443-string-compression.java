class Solution {
    public int compress(char[] chars) {
        int idx=0;
        for(int i=0;i<chars.length;i++){
            char ch=chars[i];
            int count=0;
            while(i<chars.length && chars[i]==ch){
                count++;
                i++;
            }

            if(count==1){
                chars[idx++]=ch;
            }
            else{
                chars[idx++]=ch;
                for(char c : Integer.toString(count).toCharArray()){
                    chars[idx++]=c;
                }
            }

            i--;
        }
        return idx;
    }
}