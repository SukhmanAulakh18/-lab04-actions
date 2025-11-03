public class StringProcessor {

    public String reverseText(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public int countVowels(String text) {
        if (text == null) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
