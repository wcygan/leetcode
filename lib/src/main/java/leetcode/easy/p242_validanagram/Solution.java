package leetcode.easy.p242_validanagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String first = keyFromMap(count(s));
        String second = keyFromMap(count(t));


        return first.equals(second);
    }

    HashMap<Character, Integer> count(String string) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character first = string.charAt(i);
            count.putIfAbsent(first, 0);
            count.put(first, count.get(first) + 1);
        }
        return count;
    }

    String keyFromMap(HashMap<Character, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("%c%d", e.getKey(), e.getValue()))
                .reduce("", (a, b) -> a + b);
    }
}
