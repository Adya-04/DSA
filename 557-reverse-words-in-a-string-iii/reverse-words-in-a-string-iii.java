class Solution {
    public String reverseWords(String s) {

        char[] arr = s.toCharArray();

        int start = 0;

        for (int i = 0; i <= arr.length; i++) {

            // Word ends when we reach a space
            // or the end of the string
            if (i == arr.length || arr[i] == ' ') {

                int left = start;
                int right = i - 1;

                // Reverse the current word
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }

                // Next word starts after the space
                start = i + 1;
            }
        }

        return new String(arr);
    }
}