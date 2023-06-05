import java.util.Arrays;
import java.util.Scanner;

public class hangman
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to hangman!");
        //String containing the letters of the alphabet so the user has an easier time to check which ones haven't been used.
        String letterNotUsed = "abcdefghijklmnopqrstuvwxyz";
        String[] wordToGuess = new String[] {"money", "wrist", "outline", "musical", "role"};
        //string variable which grabs a random word from the newWord array to be used in your game.
        String randomWord = wordToGuess[(int) (Math.random() * wordToGuess.length)];
        System.out.println("The word you are trying to guess has " + randomWord.length() + " letters.");
        char[] letters = new char[randomWord.length()];

        //fills in the blank spaces for the corresponding word.
        Arrays.fill(letters, '_');

        //number of lives you have.
        int lives = 6;
        Scanner userInput = new Scanner(System.in);

        //while loops that checks if you still have available lives.
        while(lives > 0)
        {
            //prints out how many lives you have and the indicator for the lives.
            System.out.print("Lives: ");
            for(int i = 0; i < lives; i++)
            {
                System.out.print("*");
            }

            System.out.println();
            System.out.println("Please input a letter: ");
            String input = userInput.nextLine();
            //Char variable for the letter inputted by the user.
            //boolean variable for the letter guessed.
            char letter = input.charAt(0);
            boolean isGuessCorrect = false;

            //for loop that checks if the letter the user inputted is a letter that is in the word.
            //if the letter is in the word, it sets the blank space to the letter the user inputted.
            for(int i = 0; i < randomWord.length(); i++)
            {
                char a = randomWord.charAt(i);

                if(a == letter)
                {
                    letters[i] = a;
                    isGuessCorrect = true;
                }
            }

            //if statement to check if your guess isn't correct. If it isn't correct, it takes away a life.
            if(!isGuessCorrect)
            {
                lives = lives - 1;
                System.out.println("Incorrect guess, try again");
            }

            //boolean variable to check if the game is finished.
            boolean isFinished = true;

            System.out.print("Word: ");

            //enhanced for loop to check if there are still blank spaces remaining.
            //If there are blank spaces, then it says that the game is still going, then it prints the blank space for the word.
            for (char c : letters)
            {
                if (c == '_')
                {
                    isFinished = false;
                }
                System.out.print(c);
            }

            System.out.println();

            //Prints out the letters that are not used.
            //If a letter has been used then it replaces that letter with a '.'
            letterNotUsed =  letterNotUsed.replace(letter, '.');
            System.out.println("Letters that haven't been used: "  + letterNotUsed);

            System.out.println("_________________________");

            //if statement to check if you won the game.
            if(isFinished)
            {
                System.out.println("Congratulations, you won!");
                break;
            }
        }

        //if statements to check if you have no lives remaining. If you don't then you lose.
        if(lives == 0)
        {
            System.out.println("Sorry you lost, the word was: " + randomWord);
        }

        System.out.println("Play again next time!");
    }
}