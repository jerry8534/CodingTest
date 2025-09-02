class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] alphabetsInfoOfT = new int[52], alphabetsInfoOfS = new int[52];

        for (int i = 0; i < t.length(); i++) {
            count(t.charAt(i), alphabetsInfoOfT);
            count(s.charAt(i), alphabetsInfoOfS);
        }

        int start = 0, end = t.length() - 1;
        int bestStart = -1, bestEnd = s.length() + 1;

        while (end < s.length()) {
            if (isIncluded(alphabetsInfoOfT, alphabetsInfoOfS)) {
                if (end - start < bestEnd - bestStart) {
                    bestStart = start;
                    bestEnd = end;
                }
                remove(s.charAt(start), alphabetsInfoOfS);
                ++start;
            } else {
                ++end;
                if (end < s.length()) {
                    count(s.charAt(end), alphabetsInfoOfS);
                }
            }
        }

        if (bestStart == -1) {
            return "";
        }

        return s.substring(bestStart, bestEnd + 1);
    }

    void count(char c, int[] alphabetsInfo) {//해당 알파벳 정보를 배열에 추가
        if ('a' <= c && c <= 'z') {
            ++alphabetsInfo[c - 'a'];
        } else {
            ++alphabetsInfo[c - 'A' + 26];
        }
    }

    void remove(char c, int[] alphabetsInfo) {//해당 알파벳 정보를 배열에서 삭제
        if ('a' <= c && c <= 'z') {
            --alphabetsInfo[c - 'a'];
        } else {
            --alphabetsInfo[c - 'A' + 26];
        }
    }

    boolean isIncluded(int[] alphabetsInfoOfT, int[] alphabetsInfoOfS) {//현재까지의 부분문자열이 t를 커버하는지
        for (int i = 0; i < 52; i++) {
            if (alphabetsInfoOfT[i] > alphabetsInfoOfS[i]) {
                return false;
            }
        }

        return true;
    }
}
