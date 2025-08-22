class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.putIfAbsent(i, 1);
            map.put(i, map.get(i) + 1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = keySet.get(i);
        }
        return ans;
    }
}
