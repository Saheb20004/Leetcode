// Optimal using Binary Search

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Total flowers required = m * k and Use long to avoid integer overflow.
        long flowersNeeded = (long) m * k;
        // If we don't have enough roses, it's impossible.
        if (flowersNeeded > bloomDay.length) {
            return -1;
        }
        // Find minimum and maximum blooming days
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        // Binary search for the minimum possible day
        int low = min;
        int high = max;

        while(low <= high){
            int mid = low + (high-low)/2; // Avoid possible integer overflow

            if( possible(bloomDay, mid, k, m) ){
                // We can make enough bouquets.
                // Try an earlier day.
                high = mid-1;
            }
            else{
                // Not enough bouquets.
                // We need more time.
                low = mid+1;
            }
        }
        return low;
    }
    

    // Checks whether we can make at least 'm' bouquets
    // by day 'day', where each bouquet needs 'k' adjacent flowers.
    public boolean possible(int[] bloomDay, int day, int k, int m) {
        int count = 0;     // Number of consecutive bloomed flowers
        int noOfBouquets = 0;     // Number of bouquets formed

        for (int i = 0; i < bloomDay.length; i++) {
            // Flowers has bloomed by the given day
            if (bloomDay[i] <= day) {
                count ++;
            } 
            else {
                // Form as many bouquets as possible
                // from the consecutive bloomed roses.
                noOfBouquets += count / k;
                // Reset consecutive count
                count = 0;
            }

        }
        // Handle the last group of consecutive bloomed roses
        noOfBouquets += count / k;

        return noOfBouquets >= m;
    }
}