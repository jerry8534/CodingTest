from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        ptr1 = 0;
        ptr2 = 0;
        n1 = nums1.size();
        n2 = nums2.size();
        nums = [];
        while ptr1 < n1 and ptr2 < n2:
            if nums1[ptr1] < nums2[ptr2]:
                nums.append(nums1[ptr1]);
                ptr1++;
            else:
                nums.append(nums2[ptr2]);
                ptr2++;
        if ptr1 < n1:
            for(int i = ptr1; i < n1; i++){
                nums.append(nums1[i]);
            }
        if ptr2 < n2:
            for(int i = ptr2; i < n2; i++){
                nums.append(nums2[i]);
            }
        int n = nums.size();
        if n % 2 == 0:
            return (v[n/2] + v[n/2 - 1]) / 2.0;
        else:
            return v[n/2];