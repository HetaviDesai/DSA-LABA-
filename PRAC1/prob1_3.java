 import java.util.Scanner;
 
public class prob1_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the sentence
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        String longestWord = "";
        int maxLength = 0;

        // Find the longest word
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }

        // Print the result
        System.out.println("Longest word: " + longestWord);
        System.out.println("Length: " + maxLength);

        sc.close();
    }
}

