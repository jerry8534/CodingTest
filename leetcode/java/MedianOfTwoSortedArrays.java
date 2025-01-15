class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m != 0 && n != 0){
            if(((m+n) % 2) == 0){
                int c = (m+n)/2-1;
                int ptr1 = 0;
                int ptr2 = 0;
                int now = 0;
                int next = 0;
                while(true){
                    if (ptr1 + ptr2 == c) {
                        return (float)(nums1[ptr1] + nums2[ptr2]) / 2;
//                    if(nums1[ptr1] > nums2[ptr2]){
//                        now = nums1[ptr1];
//                        if(ptr2<n-1){
//                            next = Math.min(nums1[ptr1+1], nums2[ptr2+1]);
//                        }else{
//                            next = nums1[ptr1+1];
//                        }
//                    }else{
//                        now = nums2[ptr2];
//                        if(ptr1<m-1){
//                            next = Math.min(nums1[ptr1+1], nums2[ptr2+1]);
//                        }else{
//                            next = nums2[ptr2+1];
//                        }
//                    }
//                    int next = Math.min(nums1[ptr1+1], nums2[ptr2+1]);
//                    return (now+next)/2;
                    }
                    if (nums1[ptr1] <= nums2[ptr2]) {
                        if(ptr1<m-1) {
                            ptr1++;
                        }else{
                            ptr2++;
                        }
                    } else {
                        if(ptr2<n-1) {
                            ptr2++;
                        }else{
                            ptr1++;
                        }
                    }
                }
            }else{
                int c = (m+n-1)/2;
                int ptr1 = 0;
                int ptr2 = 0;
                while(true){
                    if (ptr1 + ptr2 == c-1) {
                        return Math.max(nums1[ptr1], nums2[ptr2]);
                    }
                    if (nums1[ptr1] <= nums2[ptr2]) {
                        if(ptr1<m-1) {
                            ptr1++;
                        }else{
                            ptr2++;
                        }
                    } else {
                        if(ptr2<n-1) {
                            ptr2++;
                        }else{
                            ptr1++;
                        }
                    }
                }
            }
        }else if(m == 0){
            if(n % 2 == 0){
                return (float)(nums2[n/2-1] + nums2[n/2]) / 2;
            }else{
                return nums2[n/2];
            }
        }else if(n == 0){
            if(m % 2 == 0){
                return (float)(nums1[m/2-1] + nums1[m/2]) / 2;
            }else {
                return nums1[m/2];
            }
        }else{
            return 0;
        }
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int fullLength = nums1.length + nums2.length;
        int midCount = 2 - (fullLength % 2);
        int cnt = fullLength >> 1;
        double mid = 0;
        int i = 0;
        int j = 0;

        while (cnt >= 0) {
            int tmpMid;
            if (i < nums1.length && j < nums2.length) {
                tmpMid = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
            } else {
                tmpMid = (i >= nums1.length) ? nums2[j++] : nums1[i++];
            }

            if (cnt < midCount) {
                mid += tmpMid;
            }
            cnt--;
        }

        return mid / midCount;
    }
}