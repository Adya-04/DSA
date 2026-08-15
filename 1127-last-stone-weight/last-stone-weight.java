class Solution {
    public int lastStoneWeight(int[] stones) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int stone : stones) {
            list.add(stone);
        }

        while (list.size() > 1) {
            int max1 = -1;
            int max2 = -1;

            int idx1 = -1;
            int idx2 = -1;

            // Find largest
            for (int i = 0; i < list.size(); i++) {
                if (max1 < list.get(i)) {
                    max1 = list.get(i);
                    idx1 = i;
                }
            }

            // Find second largest
            for (int i = 0; i < list.size(); i++) {
                if (i != idx1 && max2 < list.get(i)) {
                    max2 = list.get(i);
                    idx2 = i;
                }
            }

            list.remove(Math.max(idx1, idx2));
            list.remove(Math.min(idx1, idx2));

            if(max1 != max2){
                list.add(max1-max2);
            }
        }

        if(list.size() == 0){
            return 0;
        }

        return list.get(0);
    }
}