import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[l] <= target && target <= nums[mid] && nums[l] <= nums[mid]){
                return Arrays.binarySearch(nums, target, l, mid);
            } else if (nums[l] > nums[mid] && (target < nums[mid] || target > nums[l])) {

            } else if (nums[mid] <= target && target <= nums[r] && nums[mid] <= nums[r]) {
                return Arrays.binarySearch(nums, target, mid, r);
            } else if (nums[mid] < nums[r] && (target > nums[mid] || target < nums[r])) {

            }
        }
        return -1;
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}