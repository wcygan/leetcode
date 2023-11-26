package leetcode.easy.p125_validpalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println(s);

        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low += 1;
                high -= 1;
            }
        }

        return true;
    }
}