class Solution {
    public boolean isPalindrome(String s) {
        int i =0;
        int j = s.length()-1;

        while(i<j){
            char a = s.charAt(i);
            char b = s.charAt(j);
            
            //Skipping all non-letters and non-digits at pos i
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            //Skipping all non-letters and non-digits at pos j
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != 
                Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}