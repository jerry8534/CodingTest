class Solution {
    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i+1, high = nums.length-1, sum = target-nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        return target;
                    }else if(nums[low] + nums[high] < sum){
                        if(Math.abs(target-closest) > Math.abs(target-nums[low]-nums[high]-nums[i])){
                            closest = nums[low] + nums[high] + nums[i];
                        }
                        low++;
                    }else{
                        if(Math.abs(target-closest) > Math.abs(target-nums[low]-nums[high]-nums[i])){
                            closest = nums[low] + nums[high] + nums[i];
                        }
                        high--;
                    }
                }
            }
        }
        return closest;
    }
}