// Optimal using Binary Search

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();

        while(low <= high){
            int mid = low + (high-low)/2; // Avoid possible integer overflow

            long hours = calculateHours(piles, mid);
            if(hours <= h){
                // mid is a possible answer
                // Try to find a smaller speed
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    

    private long calculateHours(int piles[], int k){
        long hours = 0;
        for(int pile : piles){
            // Ceiling of pile / k
            hours += (pile + (long)k - 1) / k;
        }
        return hours;
    }
}

                    // pile = 10, k = 3

                    // 10 / 3 = 3     // integer division, but we need 4 hours

                    // (10 + 3 - 1) / 3
                    // = 12 / 3
                    // = 4