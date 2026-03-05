class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int start_with_0 = 0; //010101 //even idx = 0 //odd idx = 1
        int start_with_1 = 0; //1010101

        for(int i=0; i<n; i++){
            if(i%2==0){//Even index
                if(s.charAt(i) == '1'){
                    start_with_0++;
                }
                else{
                    start_with_1++;
                }
            }
            else {
                //Odd index
                if(s.charAt(i) == '0'){
                    start_with_0++;
                }
                else{
                    start_with_1++;
                }
            }
        }

        return Math.min(start_with_0, start_with_1);
    }
}