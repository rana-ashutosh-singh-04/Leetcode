class Solution {

   
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int temp[] = new int[n1+n2];
        int i=0;
        int j=0;
        int k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                temp[k++]=nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }

        while(i<n1){
            temp[k++] = nums1[i++];
        }

        while(j<n2){
            temp[k++] = nums2[j++];
        }

        int n = temp.length;
        if(n%2==0){
            int mid = n/2;
            return (temp[mid]+temp[mid-1])/2.0;
        }else{
            return temp[n/2];
        }

    }
}