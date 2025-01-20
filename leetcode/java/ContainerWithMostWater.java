class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        Map map = new HashMap();
        for(int i = 0; i < height.length; i++){
            map.put(i, height[i]);
        }
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int a = (int)map.get(i);
                int b = (int)map.get(j);
                int h = Math.min(a, b);
                int w = j-i;
                int area = h*w;
                if(area > answer){
                    answer = area;
                }
            }
        }
        return answer;
    }
}

//이렇게 2중 for 문으로 풀면 time limit에 걸림
//이 문제는 양 쪽 끝에서 시작해서 밑 변이 작아지는 경우에 두 높이 중 작은 걸 움직여야 더 커질 수 있는 것을 이용해서 문제를 풀어야함.

class Solution {
    public static int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, getArea(left, right, height));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int getArea(int left, int right, int[] height) {
        int w = right - left, h = Math.min(height[left], height[right]);
        return w * h;
    }
}