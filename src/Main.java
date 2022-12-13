import java.io.*;
import java.util.*;

public class Main {
    public static Cypher cypher;
    public static void main(String[] args) throws Exception {
        //Get input file to cypher from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the location of the file you would like to cypher, then at the final destination put \"file name\".txt");
        File file = new File(input.nextLine());
        Scanner scan = new Scanner(file);
        
        //Get input for the amount to shift by
        System.out.println("Enter a num to shift the text by");
        int shiftBy = input.nextInt();
        cypher = new Cypher(file, shiftBy);
        cypher.shift();

        writeToFile(cypher.toString());
        scan.close();
        input.close();
    }

    //Writes the String to a new text file a location that the user specifies
    public static void writeToFile(String text){
        System.out.println("\nEnter a file path to save the cyphered text file, then at the final destination put \"file name\".txt");
        Scanner input = new Scanner(System.in);
        String filepath = input.nextLine();
        try (FileWriter write = new FileWriter(filepath)) {
            write.write(cypher.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
