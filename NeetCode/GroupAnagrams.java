class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sortedList = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        ans.add(Arrays.asList(sortedList.get(0)));
        for (int i = 1; i < sortedList.size(); i++){
            String s = sortedList.get(i);
            for(List<String> list : ans){
                if(!list.isEmpty() && list.size() == s.length()){
                    char[] c1 = list.get(0).toCharArray();
                    Arrays.sort(c1);
                    char[] c2 = s.toCharArray();
                    Arrays.sort(c2);
                    if(c1.equals(c2)){
                        list.add(s);
                    } else {
                        ans.add(Arrays.asList(s));
                    }
                } else {
                    ans.add(Arrays.asList(s));
                }
            }
        }
        return ans;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if(strs == null) return result;
        for(int i = 0; i < strs.length; i++) {
            char[] next = strs[i].toCharArray();
            Arrays.sort(next);
            String temp = Arrays.toString(next);
            if(map.containsKey(temp)) map.get(temp).add(strs[i]);
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }
        }
        return new ArrayList(map.values());
    }
}
