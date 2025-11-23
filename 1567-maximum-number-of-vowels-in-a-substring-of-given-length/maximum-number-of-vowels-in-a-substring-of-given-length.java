class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;

        for (int i=0; i<k; i++){
            if(isVowel(s.charAt(i)))
            count++;
        }

        maxCount = count;

        for(int i= k; i< s.length(); i++){

            //Checking new character
            if(isVowel(s.charAt(i))){
                count++;
            }

            //Checking the charcater that just moved from the window
            if(isVowel(s.charAt(i-k))){
                count--;
            }

            if(count>maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}