import java.io.*;
import java.util.*;

public class Cypher {
    private char[] cypherText;
    private int shift;
    private Scanner scan;

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

    private void parse(){
        String text = "";
        while(scan.hasNextLine()){
            text += scan.nextLine() +"\n";
        }
        text = text.toLowerCase();
        cypherText = new char[text.length()];
        text.getChars(0, text.length(), cypherText, 0);
    }

    public void printText(){
        System.out.println();
        for(int i = 0; i < cypherText.length; i++){
            System.out.print(cypherText[i]);
        }
    }

    public void shift(){
        int currentCharIntValue;
        for(int i = 0; i < cypherText.length; i++){
            currentCharIntValue = (int) cypherText[i] - 97;
            if(!(currentCharIntValue < 0 || currentCharIntValue > 25)){
                cypherText[i] += shift;
                if((int) cypherText[i] - 97 > 25) cypherText[i] -= 26;
            }
        }
        printText();
    }

    public String toString(){
        String temp = "";
        for(int i = 0; i < cypherText.length; i++){
            temp += cypherText[i];
        }
        return temp;
    }

}
