class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  
                return digits;
            }

            // if digit is 9, set to 0 and continue the loop for carry
            digits[i] = 0;
        }

        // If we reach here, all digits were 9 (e.g., 999 → 1000)
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;  
        return newNumber;
    }
}
