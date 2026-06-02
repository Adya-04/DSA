// Time Complexity: O(n + m)
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int m = landStartTime.length;
        int n = waterStartTime.length;

        //Start with land rides 
        int minLandFinish = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int totalTime = landStartTime[i] + landDuration[i];
            minLandFinish = Math.min(minLandFinish, landStartTime[i] + landDuration[i]);
        }

        int landToWater = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int finish = Math.max(minLandFinish, waterStartTime[i]) + waterDuration[i];
            landToWater = Math.min(landToWater, finish);
        }

        int minWaterFinish = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            minWaterFinish = Math.min(
                    minWaterFinish,
                    waterStartTime[j] + waterDuration[j]);
        }

        int waterToLand = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int finish = Math.max(minWaterFinish, landStartTime[i])
                    + landDuration[i];

            waterToLand = Math.min(waterToLand, finish);
        }

        return Math.min(landToWater, waterToLand);
    }
}