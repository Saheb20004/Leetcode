// Optimal using Binary Search Algo

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = 0;
        for(int i=0;i<weights.length;i++){
            high += weights[i];
        }

        while(low <= high){
            int mid = low + (high-low)/2;

            if(calculateDays(weights,mid) <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    private int calculateDays(int weights[], int capacity){
        int load = 0;
        int days = 1;

        for(int i=0;i < weights.length;i++){
            if(load + weights[i]  >  capacity){
                days = days+1;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }
        return days;
    }
}