// Input: Hello World
// Output: olleH dlroW

import java.util.Stack;

class GfG {
    
    static String reverseWords(String str) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ')
                st.push(str.charAt(i));
            else {
                while (!st.isEmpty()) {
                    result.append(st.pop());
                }
                result.append(" ");
            }
        }

        // Reverse the last word (if there's no space after it)
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }

    // Driver code
    public static void main(String[] args) {
        String str = "Geeks for Geeks";
        String reversed = reverseWords(str);
        System.out.println(reversed);
    }
}




//Inbuilt function
public class GfG {
    public static String reverseWords(String sentence)
    {
        // Split the string into words
        String[] words = sentence.split(" ");
        StringBuilder reverseSentence = new StringBuilder();

        // Reverse each word and append to the result
        for (String word : words) {
            reverseSentence
                .append(new StringBuilder(word).reverse().toString())
                .append(" ");
        }

        // Remove the trailing space and return the result
        return reverseSentence.toString().trim();
    }

    public static void main(String[] args)
    {
        String input = "Geeks for Geeks";
        System.out.println(reverseWords(input));
    }
}