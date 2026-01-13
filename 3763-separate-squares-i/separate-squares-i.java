class Solution {
    private int[][] squares;
    private double totalArea;

    // Check if area below yLine >= half of total area
    private boolean check(double yLine) {
        double below = 0.0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            // if bottom < yLine, some part contributes to below area
            if (y < yLine) {
                // height of part below line (clamp to square height)
                double h = Math.min(yLine - y, l);
                below += h * l;
            }
        }
        return below >= totalArea / 2.0;
    }

    public double separateSquares(int[][] squares) {
        this.squares = squares;
        totalArea = 0.0;
        // determine search range
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for (int[] sq : squares) {
            totalArea += (double) sq[2] * sq[2];
            low = Math.min(low, (double) sq[1]);
            high = Math.max(high, (double) sq[1] + sq[2]);
        }

        // binary search for y coordinate with precision 1e-5
        double eps = 1e-5;
        while (high - low > eps) {
            double mid = (low + high) / 2.0;
            if (check(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
}
