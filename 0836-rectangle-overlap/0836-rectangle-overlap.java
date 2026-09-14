class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return ! (rec1[2] <= rec2[0] || // rec1 ends at or before rec2 starts on x
                 rec1[0] >= rec2[2] || // rec1 starts at or after rec2 ends on x

                 rec1[3] <= rec2[1] || // rec1 ends at or before rec2 starts on y
                 rec1[1] >= rec2[3]); // rec1 starts at or after rec2 ends on y

    }
}

// The four miss conditions are:

// rec1 ends at or before rec2 starts on x
// rec1 starts at or after rec2 ends on x
// rec1 ends at or before rec2 starts on y
// rec1 starts at or after rec2 ends on y
// I just return the opposite of any of those being true.

