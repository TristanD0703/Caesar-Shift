import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("lib/Input.txt");
        Scanner scan = new Scanner(file);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a num to shift the text by");
        int shiftBy = input.nextInt();
        Cypher cypher = new Cypher(file, shiftBy);

        cypher.shift();

        System.out.println("\nEnter a file path to save the cyphered text file, then at the final destination put \"file name\".txt");
        input = new Scanner(System.in);
        String filepath = input.nextLine();
        try (FileWriter write = new FileWriter(filepath)) {
            write.write(cypher.toString());
        }
        scan.close();
        input.close();
    }
}
