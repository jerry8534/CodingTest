class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            int idx = s1.charAt(i) - 'a';
            s1Count[idx]++;
            s2Count[idx]++;
        }

        int start = 0;
        int end = 0;

        while(end < s2.length()) {

            if(s2Count[s2.charAt(end) - 'a'] > 0) {
                s2Count[s2.charAt(end) - 'a']--;
                if((end - start + 1) == s1.length()) {
                    return true;
                } else {
                    end++;
                }
            } else {
                if(s1Count[s2.charAt(start) - 'a'] > 0) {
                    s2Count[s2.charAt(start) - 'a'] ++;
                    start++;
                } else {
                    end ++;
                    start = end;
                }
            }
        }
        return false;
}
