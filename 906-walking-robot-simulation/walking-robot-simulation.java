class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obstSet = new HashSet<>();
        for(int[] obs: obstacles){
            obstSet.add(obs[0] + "_" + obs[1]);
        } 

        //Set default direction to North
        int[] currDir = {0,1};

        int x=0;
        int y=0;
        int maxDist = 0;

        for(int com : commands){

            if(com == -1){
                currDir = new int[]{currDir[1], -currDir[0]};
            }
            else if(com == -2){
                currDir = new int[]{-currDir[1], currDir[0]};
            }
            else{
                for(int i = 0; i<com ; i++){
                    int newX = x+currDir[0];
                    int newY = y+currDir[1];

                    String nextStep = newX + "_" + newY;

                    if(obstSet.contains(nextStep)){
                        break;
                    }

                    x= newX;
                    y= newY;
                }
            }

            maxDist = Math.max(maxDist, x*x + y*y);
        }
        return maxDist;
    }
}