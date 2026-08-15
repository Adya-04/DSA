class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        HashMap<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase();

        String word = "";

        for (char c : paragraph.toCharArray()) {

            if (Character.isLetter(c)) {
                word += c;
            } 
            else {
                if (!word.equals("")) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    word = "";
                }
            }
        }

        // Last word
        if (!word.equals("")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String ans = "";
        int maxFreq = 0;

        for (String key : map.keySet()) {

            boolean isBanned = false;

            for (String b : banned) {
                if (key.equals(b)) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned && map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                ans = key;
            }
        }

        return ans;
    }
}