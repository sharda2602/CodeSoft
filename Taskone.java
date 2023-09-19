import java.util.Scanner;
import java.util.Random;
public class Taskone 
{
    public static void main(String args[])
    {
        int min = 1, max = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        while (playAgain) 
        {
            int generatedNo = rn.nextInt(max - min + 1) + min;
            System.out.println("-------------------------------------------------");
            System.out.println("            	   WEL-COME");
            System.out.println(" \n		  NUMBER GAME");
            System.out.println("--------------------------------------------------");
           
            System.out.println("Generate a number between " + min + " and " + max + "!");
            System.out.println("You have " + maxAttempts + " attempts to guess the number!");
            System.out.println("\nBest Of Luck!");

            int attempt = 1;
            while (attempt <= maxAttempts) 
            {
                System.out.print( "\nGuess a Number: ");
                int guess = sc.nextInt();
                if (guess == generatedNo) 
                {
                    System.out.println("Congratulations! You guessed the correct number!!!");
                    score++;
                    break;
                } 
                else if (guess < generatedNo) 
                {
                    System.out.println("Too low! Try Again!");
                } 
                else 
                {
                    System.out.println("Too high! Try Again!");
                }
                attempt++;
            }
            System.out.println("\nAttempts taken: " + attempt);
            if (attempt > maxAttempts) 
            {
                System.out.println("You ran out of attempts, Better Luck next time!! \n The correct number was: " + generatedNo);
            }
            System.out.println("\nYour score is: " +score);
            System.out.println("-------------------------------------------------");
            System.out.print("\nDo you want to play again? (yes/no): ");
            String x = sc.next();
            playAgain = x.equalsIgnoreCase("yes");
        }
        
    }
}