class Solution {
    public int getMaxFrequent(int[] freq) {
        int m = 0;
        for(int f : freq)
            m = Math.max(f, m);
        return m;
    }

    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int[] freq = new int[26];

        for(int l = 0, r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            freq[ch-'A']++;

            int maxCount = getMaxFrequent(freq);

            while(r - l + 1 - maxCount > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
