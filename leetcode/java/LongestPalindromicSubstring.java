class Solution {
    public String longestPalindrome(String text) {
        int max_s = 0, max_e = 0;
        boolean[][] dp = new boolean[text.length()][text.length()];
        for (int s = text.length() - 1; s > -1; s--) {
            for (int e = s; e < text.length(); e++) {
                if (s == e)
                    dp[s][e] = true;
                else if (s + 1 == e)
                    dp[s][e] = text.charAt(s) == text.charAt(e);
                else
                    dp[s][e] = text.charAt(s) == text.charAt(e) && dp[s + 1][e - 1];

                if (dp[s][e] && max_e - max_s < e - s) {
                    max_s = s;
                    max_e = e;
                }
            }
        }
        return text.substring(max_s, max_e + 1);
    }
}