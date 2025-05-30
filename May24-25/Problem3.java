import java.util.*;

class Problem3{
    public static boolean balanceStr(String str){
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else {
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if(top == '(' && ch != ')' ||
                top == '{' && ch != '}' ||
                top == '[' && ch != ']'){
                    return false;
                }
            }   
        }
        return st.isEmpty();
    }       
    public static void main(String[] args){
        String str = "()[]{)";
        Boolean result = balanceStr(str);
        System.out.println(result);
    }
}