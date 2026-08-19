class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0;
        int j=0;

        ArrayList<Integer> ans=new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]) i++;
            else if(nums2[j] < nums1[i]) j++;
            else{ // nums1[i]==nums2[j]
                if(ans.size() == 0 || ans.get( ans.size()-1 ) != nums1[i])
                    ans.add(nums1[i]);
                    i++;
                    j++;
            }
        }

        int intersect[]=new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            intersect[k]=ans.get(k);
        }

        return intersect;
    }
}