class Solution {
    public String reorganizeString(String s) {
    // Count frequencies
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }

    // Find the character with the maximum frequency
    int maxCount = 0;
    char maxChar = 'a';
    for (int i = 0; i < 26; i++) {
        if (count[i] > maxCount) {
            maxCount = count[i];
            maxChar = (char) (i + 'a');
        }
    }

    // Check if reorganization is possible
    if (maxCount > (s.length() + 1) / 2) {
        return "";
    }

    char[] result = new char[s.length()];
    int index = 0;

    // Place the highest frequency character at even positions
    while (count[maxChar - 'a'] > 0) {
        result[index] = maxChar;
        index += 2;
        count[maxChar - 'a']--;
    }

    // Fill other characters
    for (int i = 0; i < 26; i++) {
        while (count[i] > 0) {
            if (index >= result.length) {
                index = 1;
            }
            result[index] = (char) (i + 'a');
            index += 2;
            count[i]--;
        }
    }

    return new String(result);
}
}