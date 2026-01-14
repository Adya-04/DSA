class Solution {
    
    private boolean check(int[][] squares, double mid_y, double totalArea){
        double bottomArea = 0.0;

        for(int[] square: squares){
            double y = square[1];
            double l = square[2];

            double bot_y = y;
            double top_y = y+l;

            if(mid_y >= top_y){
                // full square below
                bottomArea += (l*l);
            }
            else if(mid_y > bot_y){
                // partial square below
                bottomArea += l * (mid_y-bot_y);
            }
        }

        return bottomArea >= totalArea / 2.0 ; 
    }

    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double total = 0.0;

        for(int[] square: squares){
            double y = square[1];
            double l = square[2];

            total += l*l;
            low = Math.min(y,low);
            high = Math.max(y+l, high);
        }

        double resultYLine = 0.0;

        while(high-low > 1e-5){
            double midY = low + (high-low)/2.0;
            resultYLine = midY;

            if(check(squares,midY,total)){
                // bottom area is more than half, move down
                high = midY;
            }
            else{
                low = midY;
            }
        }

        return resultYLine;
    }
}
