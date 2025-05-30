import java.util.*;

public class Problem8 {
    List<List<String>> groupAnagram(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            // if the str is key then put the key into arraylist
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values()); 
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int sizeArray = sc.nextInt();
        String[] strs = new String[sizeArray];
        for(int i = 0; i<sizeArray; i++){
            strs[i] = sc.next();
        }
        Problem8 obj = new Problem8();
        List<List<String>> result = obj.groupAnagram(strs);
        System.out.println(result);
        sc.close();

    }

}
    

