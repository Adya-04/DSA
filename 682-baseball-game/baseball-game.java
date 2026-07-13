class Solution {
    public int calPoints(String[] operations) {
        List<Integer> ls = new ArrayList<>();

        for (String op : operations) {
            if (op.equals("C")) {
                ls.remove(ls.size() - 1);
            } else if (op.equals("D")) {
                ls.add(2 * ls.get((ls.size()) - 1));
            } else if (op.equals("+")) {
                ls.add(ls.get((ls.size()) - 1) + ls.get((ls.size()) - 2));
            } else {
                ls.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : ls) {
            sum += score;
        }
        return sum;
    }
}