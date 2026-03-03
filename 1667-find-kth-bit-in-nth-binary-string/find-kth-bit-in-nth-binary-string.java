class Solution {
    public char findKthBit(int n, int k) {
        String s = solve(n);
        return s.charAt(k-1);
    }

    public String solve (int i){
        if(i==1) return "0";
        String s = solve(i-1);
        return s + "1" + reverse(invert(s));
    }

    public String invert(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}