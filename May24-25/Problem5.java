import java.util.*;

class Problem5 {
    public static boolean anagramStrings(String word1, String word2) {
        char[] word1ch = word1.toCharArray();
        char[] word2ch = word2.toCharArray();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (char ch : word1ch) {
            set1.add(ch);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2ch) {
            set2.add(ch);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        l1.addAll(map1.values());
        l2.addAll(map2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        if(word1.length() == word2.length() && set1.equals(set2) && l1.equals(l2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word1 = "abbzzca";
        String word2 = "babzzca";
        boolean result = anagramStrings(word1, word2);
        System.out.println(result);
    }
}
