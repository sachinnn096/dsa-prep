package Heap.FAQ;

class ReOragnizingString {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }

        if (max > (s.length() + 1) / 2) return "";

        char[] res = new char[s.length()];
        int idx = 0;

        // Fill the most frequent character into even indices first
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }

        // Fill the rest of the characters
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1; // Start filling odd indices once even are done
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }

        return new String(res);
    }
}