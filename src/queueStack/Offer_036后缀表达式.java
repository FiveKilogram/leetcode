package queueStack;

import java.util.Stack;

public class Offer_036后缀表达式 {
    public static void main(String[] args) {
        int i = evalRPN(new String[]{"4","13","5","/","+"});
        System.out.println(i);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")){
                result = stack.pop() + stack.pop();
                stack.push(result);
            }
            else if(tokens[i].equals("-")){
                result = stack.pop() - stack.pop();
                stack.push(result);
            }
            else if(tokens[i].equals("*")){
                result = stack.pop() * stack.pop();
                stack.push(result);
            }
            else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                result = b / a;
                stack.push(result);
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return result;
    }

}
