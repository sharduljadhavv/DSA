package hashing;

import java.util.Arrays;
import java.util.HashMap;


class IsAnagram{
    public static boolean isValidAnagramBrute (String s, String t){

        //comparing length of both strings , if not equal then not a anagram
        if(s.length() != t.length()) return false; 

        //converting both the strings into char array so we can compare it later
        // TC = O(n) | SC = O(n) — copies every char into a new array of size n
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        
        //Arrays.sort uses dual-pivot quicksort,  TC = O(n log n) | SC = O(log n)
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        //Compares element by element, no extra memory created, TC = O(n) | SC = O(1) 
        return Arrays.equals(sArray,tArray);
    }

    public static boolean isValidAnagramOptimised( String s, String t){
        if(s.length()!= t.length()) return false;

        HashMap<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()){
            // TC: O(1) | SC: O(1) — hashmap lookup with fallback default value
            // TC: O(1) | SC: O(1) — hashmap insert or update in place
            count.put(c, count.getOrDefault(c, 0)+ 1);
        }

        for (char c : t.toCharArray()){
            count.put(c,count.getOrDefault(c, 0)- 1);
        }

        for( int values: count.values()){
            if (values != 0) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "shardul";
        String t = "sharul";

        System.out.println(isValidAnagramBrute(s, t));
        System.out.println(isValidAnagramOptimised(s, t));

    }
}


// Function              TC            SC          Why
// ────────────────────────────────────────────────────────────────────
// s.length()            O(1)          O(1)        stored as a field
// s.toCharArray()       O(n)          O(n)        creates new array
// Arrays.sort()         O(n log n)    O(log n)    dual-pivot quicksort
// Arrays.equals()       O(n)          O(1)        element comparison
// map.getOrDefault()    O(1)          O(1)        hashmap lookup
// map.put()             O(1)          O(1)        hashmap insert
// map.values()          O(1)*         O(1)        max 26 keys = constant