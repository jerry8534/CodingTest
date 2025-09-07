class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i = tokens.length - 1; i >= 0; i--){
            stack.push(tokens[i]);
        }

        Stack<Integer> stack2 = new Stack<>();
        String temp = '';
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp.equals("+")){
                int i = stack2.pop() + stack2.pop();
                stack2.push(i);
            } else if(temp.equals("-")){
                int i = stack2.pop();
                stack2.push(stack2.pop() - i);
            } else if(temp.equals("*")){
                int i = stack2.pop() * stack2.pop();
                stack2.push(i);
            } else if(temp.equals("/")){
                int i = stack2.pop();
                stack2.push(stack2.pop() / i);
            } else {
                stack2.push(Integer.valueOf(temp));
            }
        }
        return stack2.pop();
    }
}
