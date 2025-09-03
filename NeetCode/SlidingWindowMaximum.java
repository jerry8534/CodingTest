class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        int[] res = new int[l - k + 1];
        for(int i = 0; i < l-k+1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
