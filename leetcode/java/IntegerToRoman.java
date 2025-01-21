class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//13
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//13
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}