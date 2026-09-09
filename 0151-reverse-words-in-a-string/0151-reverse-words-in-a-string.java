class Solution {

    public String reverseWords(String s) {

        // Remove leading/trailing spaces
        // and reduce multiple spaces to single spaces
        s = s.trim().replaceAll("\\s+", " ");

        char[] arr = s.toCharArray();

        // Step 1: Reverse the whole string
        reverse(arr, 0, arr.length - 1);

        // Step 2: Reverse each individual word
        int start = 0;

        for (int i = 0; i <= arr.length; i++) {

            // End of a word
            if (i == arr.length || arr[i] == ' ') {

                reverse(arr, start, i - 1);

                start = i + 1;
            }
        }

        return new String(arr);
    }

    // Function to reverse characters from start to end
    private void reverse(char[] arr, int start, int end) {

        while (start < end) {

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}