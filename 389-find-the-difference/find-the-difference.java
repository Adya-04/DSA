class Solution {
    public char findTheDifference(String s, String t) {
        int[] characters = new int[26];

        for(char c: t.toCharArray()){
            characters[c-'a']++;
        }

        for(char c: s.toCharArray()){
            characters[c-'a']--;
        }

        for(int i=0; i<26; i++){
            if(characters[i] == 1){
                return (char)(i + 'a');
            }
        }
        return ' ';
    }
}