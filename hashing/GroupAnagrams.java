package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // TC: O(1) | SC: O(n) to tracks which strings are already grouped
        //this created a array of size of the strs and the initial values are false for each indeax
        //[false,false,false,...]
        boolean[] visited = new boolean[strs.length];

        // TC: O(1) | SC: O(n*k) — final result grows with input
        List<List<String>> result = new ArrayList<>();

        // TC: O(n) | SC: O(1) — outer loop
        // iterate over each word. 
        for (int i = 0; i < strs.length; i++) {

            //if this word is visited then skip it
            if (visited[i])
                continue;

            // TC: O(1) | SC: O(k) — new group for this anagram family
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            // TC: O(n) | SC: O(1) — inner loop compares against all others
            for (int j = i + 1; j < strs.length; j++) {

                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(group);
        }
        return result;

    }

    //same is anargam solution used for this    
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray(); // TC: O(k) | SC: O(k)
        char[] tArr = t.toCharArray(); // TC: O(k) | SC: O(k)
        Arrays.sort(sArr); // TC: O(k log k) | SC: O(log k)
        Arrays.sort(tArr); // TC: O(k log k) | SC: O(log k)
        return Arrays.equals(sArr, tArr); // TC: O(k) | SC: O(1)
    }
}
