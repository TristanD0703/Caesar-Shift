import java.io.*;
import java.util.*;

public class Cypher {
    private char[] cypherText;
    private int shift;
    private Scanner scan;

    //Sets up the Cypher object by parsing the text file and converts each character in the parsed String into a char datatype
    public Cypher(File file, int shift){
        this.shift = shift;

        try{
            scan = new Scanner(file);
        } catch(IOException e) {
            System.out.println("An error has occurred. File not found.");
            e.getStackTrace();
        }
        parse();
        printText();
    }

    //Scans the file and converts the String into a char array
    private void parse(){
        String text = "";
        while(scan.hasNextLine()){
            text += scan.nextLine() +"\n";
        }
        text = text.toLowerCase();
        cypherText = new char[text.length()];
        text.getChars(0, text.length(), cypherText, 0);
    }

    //Prints the cypherText char array to the terminal
    public void printText(){
        System.out.println();
        for(int i = 0; i < cypherText.length; i++){
            System.out.print(cypherText[i]);
        }
    }

    //Gets the int representation of each char in the array, then adds the shift amount to the char value
    //Checks if the shift goes beyond the limits of the alphabet. If so, it adds the char value back into the
    //alphabet limits. Also checks if the current character is a special character, and ignores it if so.
    public void shift(){
        int currentCharIntValue;
        for(int i = 0; i < cypherText.length; i++){
            currentCharIntValue = (int) cypherText[i] - 97;
            if(!(currentCharIntValue < 0 || currentCharIntValue > 25)){
                cypherText[i] += shift;
                if((int) cypherText[i] - 97 > 25) cypherText[i] -= 26;
                else if((int) cypherText[i] - 97 < 0) cypherText[i] += 26;
            }
        }
        printText();
    }

    //Outputs the string representation of the cypher
    public String toString(){
        String temp = "";
        for(int i = 0; i < cypherText.length; i++){
            temp += cypherText[i];
        }
        return temp;
    }

}