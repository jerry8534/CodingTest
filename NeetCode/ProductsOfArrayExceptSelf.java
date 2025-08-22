class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        boolean isFound = Arrays.stream(nums)
                .anyMatch(score -> score == 0);
        if(isFound) {
            int cnt = 0;
            int index = 0;
            int rst = 1;
            for(int i = 0; i < len; i++) {
                if(nums[i] == 0){
                    cnt++;
                    index = i;
                } else {
                    rst *= nums[i];
                }
                if(cnt == 2) return new int[len];
            }
            int[] ans = new int[len];
            ans[index] = rst;
            return ans;
        }
        int all = 1;
        for(int i = 0; i < len; i++) {
            all *= nums[i];
        }
        int[] ans = new int[len];
        for(int i = 0; i < len; i++) {
            ans[i] = all / nums[i];
        }
        return ans;
    }
}
