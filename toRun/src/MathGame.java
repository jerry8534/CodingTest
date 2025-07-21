import java.util.*;
import java.util.stream.Stream;

public class MathGame {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        List<String> splits = generateSplits(S);
        for (String split : splits) {
            String red = split.substring(0, split.length() / 2);
            String blue = split.substring(split.length() / 2);
            List<String> redExpressions = generateExpressions(red);
            List<String> blueExpressions = generateExpressions(blue);
            for (String redExp : redExpressions) {
                for (String blueExp : blueExpressions) {
                    if (evaluate(redExp) == evaluate(blueExp)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    // Generate all possible splits of the input string
    private static List<String> generateSplits(String S) {
        List<String> splits = new ArrayList<>();
//        Stream
        int n = S.length();
        for (int i = 1; i < n; i += 2) {
            for (int j = 0; j < n - i; j += 2) {
                splits.add(S.substring(j, j + i) + "|" + S.substring(j + i));
            }
        }
        return splits;
    }

    // Generate all possible expressions that satisfy the given formula
    private static List<String> generateExpressions(String formula) {
        List<String> expressions = new ArrayList<>();
        int n = formula.length();
        if (n == 1) {
            expressions.add(formula);
            return expressions;
        }
        for (int i = 1; i < n; i += 2) {
            String left = formula.substring(0, i);
            String right = formula.substring(i + 1);
            List<String> leftExp = generateExpressions(left);
            List<String> rightExp = generateExpressions(right);
            for (String l : leftExp) {
                for (String r : rightExp) {
                    expressions.add(l + formula.charAt(i) + r);
                }
            }
        }
        return expressions;
    }

    // Evaluate the expression and return the result
    private static int evaluate(String exp) {
        int result = 0;
        int n = exp.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            j = i + 1;
            while (j < n && Character.isDigit(exp.charAt(j))) {
                j++;
            }
            int num = Integer.parseInt(exp.substring(i, j));
            if (i == 0) {
                result = num;
            } else if (exp.charAt(i - 1) == '+') {
                result += num;
            } else {
                result -= num;
            }
            i = j + 1;
        }
        return result;
    }
}