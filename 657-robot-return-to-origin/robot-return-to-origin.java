class Solution {
    public boolean judgeCircle(String moves) {
        int countR = 0;
        int countL = 0;
        int countU = 0;
        int countD = 0;
        for(char c : moves.toCharArray()){
            if(c == 'R'){
                countR++;
            }
            else if(c == 'L'){
                countL++;
            }
            else if(c == 'U'){
                countU++;
            }
            else if(c == 'D'){
                countD++;
            }
        }
        if(countR == countL && countU == countD){
            return true;
        }
        else{
            return false;
        }
    }
}