class Solution {
    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            // update map1
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for (char c : word2.toCharArray()) {
            // update map2
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        List<Integer> freq1 = new ArrayList<>(map1.values());
        List<Integer> freq2 = new ArrayList<>(map2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return map1.keySet().equals(map2.keySet()) && freq1.equals(freq2);
    }
}