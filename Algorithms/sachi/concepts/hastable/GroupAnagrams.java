package concepts.hastable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(countSort("puli"));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = countSort(str);
            List<String> list;
            if (map.containsKey(sorted)) {
                list = map.get(sorted);
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
            }
            map.put(sorted, list);
        }
        return new ArrayList<>(map.values());
    }

    public static String countSort(String str) {
        StringBuilder sorted = new StringBuilder();
        int[] counts = new int[26];
        for (Character c : str.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                sorted.append((char) ('a' + i));
                counts[i]--;
            }
        }
        return sorted.toString();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#").append(count[i]);
            }
            String hash = sb.toString();
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
