class Solution {
    public boolean stoneGameIX(int[] stones) {
        // 🔢 Count stones based on remainder modulo 3
        int count[]=new int[3];

        for(int stone : stones){
            count[stone % 3]++;
        }
        // 🟢 Even number of remainder-0 stones
        if(count[0] % 2 == 0){
            // Alice needs both remainder 1 and remainder 2 stones
            return count[1]>0 && count[2]>0;
        }
        // 🔴 Odd number of remainder-0 stones
        // Alice wins if one non-zero remainder group
        // is sufficiently larger than the other.

        return Math.abs(count[1]-count[2]) > 2;
    }
}