import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = -1;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target){
                t = i;
            }
        }

        if(t == -1) return false;

        int[] arr = matrix[t];
        int index = Arrays.binarySearch(arr, target);
        return index >= 0;
    }
}
