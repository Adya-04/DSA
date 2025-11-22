class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int dir = 0;
        /*
        dir = 0 Left to Right
        dir = 1 Top to Down
        dir = 2 Right to Left
        dir = 3 Down to Top
        */
        int top   = 0;
        int down  = r-1;
        int left  = 0;
        int right = c-1;

        List<Integer> result = new ArrayList<>();

        while(top <= down && left <= right){
            if(dir ==0){
                for(int i = left; i<=right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i<= down; i++){
                    result.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i = right; i>= left; i--){
                    result.add(matrix[down][i]);
                }
                down--;
            }
            else if(dir == 3){
                for(int i = down; i>= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }

            dir = (dir+1)%4;
        }
        return result;
    }
}