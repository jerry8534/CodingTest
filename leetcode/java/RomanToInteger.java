class Solution {
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//13
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//13
        int answer = 0;
        for(int i = 0; i < values.length; i++){
            while(s.startsWith(symbols[i])){
                answer += values[i];
                s = s.substring(symbols[i].length());
            }
        }
        return answer;
    }
}