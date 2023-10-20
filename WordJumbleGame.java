import java.util.Random;
import java.util.Scanner;

public class WordJumbleGame {
  // main method
    public static void main(String[] args) {
        String[] words = { "cat", "computer", "dog", "pizza", "racecar", "cupcake", "muffin", "animal" };
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unscramble the word to win!");
        String wordGuess = getRandomWord(words, random);
        String jumbledWord = jumbleWord(wordGuess, random);
        System.out.println("Your word is: " + jumbledWord);
        int attempts = 3;
        boolean hasGuessedCorrectly = false;

        //contains iteration
        while (attempts > 0 && !hasGuessedCorrectly) {
            System.out.println("You have " + attempts + " attempts left");
            System.out.print("Your guess: ");
            String guess = scanner.nextLine();

              // conditional statements 
            if (guess.equals(wordGuess)) {
                System.out.println("You win");
                hasGuessedCorrectly = true;
            } else {
                System.out.println("Incorrect guess again");
                attempts--;
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("You lose the word was: " + wordGuess);
        }

        scanner.close();
    }

    // randomly selects the word, method that contains parameter
    public static String getRandomWord(String[] words, Random random) {
        int index = random.nextInt(words.length);
        return words[index];
    }

    // jumbles the characters, method that contains parameter
    public static String jumbleWord(String word, Random random) {
      // .toCharArray is a method from the string class (1)
        char[] characters = word.toCharArray();
        // contains .length() which is a method from string class (2)

        for (int i = characters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[index];
            characters[index] = temp;
        }

        return new String(characters);
    }
}
