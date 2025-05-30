import java.util.*;

class Problem9{
    public static Integer lastWord(String str){
        str = str.trim();
        int count = 0;

        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i) != ' '){
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String str = "   ";
        Integer result = lastWord(str);
        System.out.println(result);

    }
}