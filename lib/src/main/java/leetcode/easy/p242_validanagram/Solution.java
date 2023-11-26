package leetcode.easy.p242_validanagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // Trick, for every character in "s", add one to it's count
    //        for every character in "t", remove one from it's count
    //        if every entry is 0 at the end, it's an anagram
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character first = s.charAt(i);
            Character second = t.charAt(i);
            count.putIfAbsent(first, 0);
            count.putIfAbsent(second, 0);
            count.put(first, count.get(first) + 1);
            count.put(second, count.get(second) - 1);
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
