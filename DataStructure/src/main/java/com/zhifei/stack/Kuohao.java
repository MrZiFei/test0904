package com.zhifei.stack;

public class Kuohao {

    private Stack<Character> stack;

    public static void main(String[] args) {
        Kuohao kuohao = new Kuohao();
        System.out.println(kuohao.isValid("{()}"));
    }


    public boolean isValid(String s) {
        stack = new ArrayStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                Character suffix = stack.pop();
                if (c == ')' && suffix != '(') {
                    return false;
                }
                if (c == ']' && suffix != '[') {
                    return false;
                }
                if (c == '}' && suffix != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
