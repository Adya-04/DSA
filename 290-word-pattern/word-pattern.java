class Solution {
    public boolean wordPattern(String pattern, String s) {

        int i=0;
        HashMap<Character, String> map = new HashMap<>();
        String word = "";

        for(int j=0; j < s.length(); j++){
            if(s.charAt(j) == ' '){

                if(i >= pattern.length()) return false;

                char ch = pattern.charAt(i);

                if(map.containsKey(ch)){
                    if(!map.get(ch).equals(word)) return false;
                }
                else{
                    if(map.containsValue(word)) return false;
                    map.put(ch,word);
                }

                i++;
                word = "";
            }
            else{
                word += s.charAt(j);
            }
        }

        // Last word
        if (i >= pattern.length()) return false;

        char ch = pattern.charAt(i);

        if (map.containsKey(ch)) {
            if (!map.get(ch).equals(word)) return false;
        } else {
            if (map.containsValue(word)) return false;
            map.put(ch, word);
        }

        return i+1 == pattern.length();
    }
}