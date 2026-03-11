class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int ans=0;
        int power =1;
        while(n!=0){
            int rem = n%2;
            ans += (1-rem) * power;
            power*=2;
            n/=2;
        }
        return ans;
    }
}