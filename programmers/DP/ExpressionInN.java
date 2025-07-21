import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        // init list of set
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // add N for 1
        dp.get(1).add(N);

        // search possible number made by N using i times
        for (int i = 2; i <= 8; i++) {
            // make number with N, i times
            StringBuilder sb = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));

            // calculate using dp[j] & dp[i-j]
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }

            // check set includes number
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
