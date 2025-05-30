/* Rearrange a no to find min possible no in o(n) and constant space.
 
for eg input 
1. 324 -> output 234
2. 50221 - 01225*/
public class Problem9 {
    public static String minorder(String num){
        int[] count = new int[10];
        for(int i =0; i<num.length(); i++){
            count[num.charAt(i) - '0']++;
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i <= 9; i++){
            for(int freq = 0; freq < count[i]; freq++){
                str.append(i);
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        System.out.println(minorder("324"));
        System.out.println(minorder("50221"));
    } 
}
