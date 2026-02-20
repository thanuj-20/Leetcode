import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            
            // When balance becomes zero, we found a special substring
            if (count == 0) {
                // Recursively solve inner substring
                String inner = s.substring(start + 1, i);
                String processed = "1" + makeLargestSpecial(inner) + "0";
                list.add(processed);
                start = i + 1;
            }
        }
        
        // Sort descending to get lexicographically largest
        Collections.sort(list, Collections.reverseOrder());
        
        // Join all parts
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }
        
        return result.toString();
    }
}