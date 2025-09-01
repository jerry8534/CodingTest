class Solution {
    public int lengthOfLongestSubstring(String s) {
        String longest = "";
        int res = 0;
        int start = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++){
            if(longest.contains(s.substring(i, i+1))){
                int subi = longest.indexOf(s.substring(i, i+1));
                String sub = longest.substring(subi);
                start = i + 1 - sub.length();
                longest = s.substring(start, i+1);
                res = Math.max(res, longest.length());
            } else {
                longest += s.substring(i, i+1);
                res = Math.max(res, longest.length());
            }
        }
        return res;
    }
}
