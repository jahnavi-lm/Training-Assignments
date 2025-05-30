/* Strings
Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.*/
import java.util.*;

public class Problem7 {
    public static int lenSubString(String str){
        int l = 0; 
        int maxlen = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            while(set.contains(ch)){
                set.remove(str.charAt(l));
                l++;
            }
            set.add(ch);
            maxlen = Math.max(maxlen, i-l+1);
        }
        return maxlen;
    }
    public static void main(String[] args){
        String str = "abcabcbb";
        int len = lenSubString(str);
        System.out.println(len);
    }
}
