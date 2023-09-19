import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class tasktwo
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String in = "";
        int wc = 0;
        System.out.println("Enter a text or provide a file path:");
        String userInput = sc.nextLine();
        File file = new File(userInput);     // Check if the input is a file path
        if (file.exists()) 
        {
            try 
            {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) 
                {
                    in += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("File not found!");
                return;
            }
        } 
        else 
        {
            in = userInput;
        }   
        String[] words = in.split("[\\p{Punct}\\s]+"); //Split the input into words using space or punctuation as delimiters
        for (String word : words) 
        {
            if (!word.isEmpty()) 
            {
                wc++;
            }
        }
        System.out.println("Total words: " + wc);
    }
}