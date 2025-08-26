class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int a = target - numbers[i];
            for(int j = i + 1; j < numbers.length; j++){
                if(a == numbers[j]){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return null;
    }
}
