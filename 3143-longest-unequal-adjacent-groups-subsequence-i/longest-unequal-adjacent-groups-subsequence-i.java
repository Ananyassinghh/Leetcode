import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int prevGroup = -1;

        for (int i = 0; i < words.length; i++) {
            if (groups[i] != prevGroup) {
                result.add(words[i]);
                prevGroup = groups[i];
            }
        }

        return result;
    }
}
