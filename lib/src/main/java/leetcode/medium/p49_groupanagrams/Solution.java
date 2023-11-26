package leetcode.medium.p49_groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            String key = keyFromMap(count(s));
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return groups.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
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