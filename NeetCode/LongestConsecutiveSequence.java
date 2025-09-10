class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0 ;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        List<Integer> sortedSet = new ArrayList<>(set);
        Collections.sort(sortedSet);
        int max = 0;
        int temp = sortedSet.get(0);
        int tm = 1;
        for(int num : sortedSet){
            if(num - temp == 1) {
                tm++;
                temp = num;
                if(tm > max){
                    max = tm;
                }
            } else {
                tm = 1;
                temp = num;
            }
        }
        return max;
    }
}
