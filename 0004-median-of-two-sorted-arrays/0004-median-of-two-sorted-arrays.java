class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m+n;

        int count = 0;
        int idx2 = l/2;
        int idx1= idx2 - 1;
        int idx1el = -1;
        int idx2el = -1;

        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]) {
                if(count == idx1)    idx1el = nums1[i];
                if(count == idx2)    idx2el = nums1[i];
                count ++;
                i++;
            }
            else{
                if(count == idx1)    idx1el = nums2[j];
                if(count == idx2)    idx2el = nums2[j];
                count ++;
                j++;
            }
        }

        while(i < m){
            if(count == idx1)    idx1el = nums1[i];
            if(count == idx2)    idx2el = nums1[i];
            count ++;
            i++;
        }
        while(j < n){
           if(count == idx1)    idx1el = nums2[j];
           if(count == idx2)    idx2el = nums2[j];
           count ++;
           j++;
        }

        if( l % 2 == 1){
            return (double) idx2el;
        }
        else{
            double ans = (double) idx2el + idx1el;
            return ans / 2;
        }
    }
}