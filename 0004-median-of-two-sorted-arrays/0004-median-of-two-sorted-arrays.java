class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m+n;

        int nums[]=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]) {
                nums[k++] = nums1[i];
                i++;
            }
            else{
                nums[k++] = nums2[j];
                j++;
            }
        }

        while(i < m){
            nums[k++] = nums1[i];
            i++;
        }
        while(j < n){
            nums[k++] = nums2[j];
            j++;
        }

        if( l % 2 == 1){
            return (double) nums[l / 2];
        }
        else{
            double ans = (double) nums[l / 2] + nums[l / 2  -  1];
            return ans / 2;
        }
    }
}