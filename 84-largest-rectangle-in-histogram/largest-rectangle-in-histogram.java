class Solution {
    //Time: O(n)
    // Space:  O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] nse = nextSmallerElement(heights);
        int[] pse = previousSmallerElement(heights);

        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int[] nextSmallerElement(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] previousSmallerElement(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
