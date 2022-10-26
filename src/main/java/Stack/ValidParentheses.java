package Stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            Character curr = s.charAt(i);
            Character pop;
            if(curr == '(' || curr == '{' || curr == '['){
                st.push(curr);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                pop = st.pop();
                if(!checkEquality(pop,curr)){
                    System.out.println(pop + ":" + curr);
                    return false;
                }
            }

        }
        return st.isEmpty();
    }

    public boolean checkEquality(Character a, Character b){
        if(a == '(' && b == ')'){
            return true;
        }
        if(a == '[' && b == ']'){
            return true;
        }
        if(a == '{' && b == '}'){
            return true;
        }
        return false;
    }
}
