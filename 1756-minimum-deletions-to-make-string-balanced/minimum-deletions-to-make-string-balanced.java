class Solution {
    public int minimumDeletions(String s) {

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int count = 0;

        for(int i =0; i<n; i++){

            if( !stack.isEmpty() && s.charAt(i)=='a' && stack.peek() == 'b'){//'ba'
                stack.pop();
                count++;
            }
            else{
                stack.push(s.charAt(i));
            }

        }  
        
        return count;  
    }
}