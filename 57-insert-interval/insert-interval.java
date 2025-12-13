class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] result = new int[n+1][2];
        int i = 0;//for traversing intervals
        int j = 0;//for traversing result

        //add all the elements that end before the new element starts
        while(i<n && intervals[i][1] < newInterval[0]){
            result[j++] = intervals[i++];
        }

        //Merge overlapping intervals
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i++][1]);
        }

        result[j++] = newInterval;

        //Add remaining intervals
        while(i<n){
            result[j++] = intervals[i++];
        }

        return Arrays.copyOf(result, j);
        //Because the result array is preallocated with maximum size n+1, but the actual number of intervals  inserted is j. Arrays.copyOf trims the unused part and returns only valid intervals.

    }
}