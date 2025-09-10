class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int height : heights) {
            hs.add(height);
        }
        List<Integer> tempSet = new ArrayList<>(hs);
        Collections.sort(tempSet);
        for(int i = tempSet.size() - 1; i >= 0; i--) {
            st.push(tempSet.get(i));
            System.out.println(st.peek());
        }

        for(int i = 0; i < st.size(); i++) {
            int w = findLongestIndex(heights);
            int h = st.pop();
            System.out.println("w = " + w + " h = " + h);
            System.out.println("================================");
            res = Math.max(res, w * h);
            for(int j = 0; j < heights.length; j++){
                if(heights[j] == h){
                    heights[j] = 0;
                }
            }
        }

        return res;
    }

    public int findLongestIndex(int[] arr){
        int res = 0;
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            int now = i - temp + 1;
            if(now > res){
                res = now;
            }
            if(arr[i] == 0) {
                temp = i + 1;
            }
        }
        System.out.println("res = " + res);
        return res;
    }
}