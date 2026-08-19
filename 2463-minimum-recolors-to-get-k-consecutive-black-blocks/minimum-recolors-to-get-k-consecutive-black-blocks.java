class Solution {
    public int minimumRecolors(String blocks, int k) {

        int countW = 0;

        for(int i=0; i<k; i++){
            if(blocks.charAt(i) == 'W'){
                countW++;
            }
        }
        int min = countW;

        for(int i = k; i<blocks.length(); i++){
            if(blocks.charAt(i) == 'W'){
                countW++;
            }
            if(blocks.charAt(i-k) == 'W'){
                countW--;
            }
            min = Math.min(min, countW);
        }
        return min;
    }
}