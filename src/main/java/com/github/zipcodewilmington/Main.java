package com.github.zipcodewilmington;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String validYN = "yn";
    private static String validLetter = "abcdefghijklmnopqrstuvwxyz-";
    private static ArrayList<String> validYNList;
    private static ArrayList<String> validLetterList;
    private static String yesNoMessage = "Wanna play again? (\'y\' or \'n\') ";
    private static String guessMessage = "Enter a single character:  ";

    public static void main(String[] args){
        validYNList = new ArrayList<>(Arrays.asList(validYN.split("")));
        validLetterList = new ArrayList<>(Arrays.asList(validLetter.split("")));

        do { } while(run());

        quit();
    }

    private static boolean run(){
        System.out.println("Welcome to Hangman ver. 1.0");
        Hangman mrMan = new Hangman();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Current guesses: ");
            if(mrMan.printGuess()){
                System.out.println("\n\nCongratulations! You winnin\' son!\n");
                break;
            }

            // making sure the current guess is valid
            Character curGuess = getValidInput(in, validLetterList, guessMessage);
            if(curGuess.equals('-')){
                quit();
            }
            mrMan.makeGuess(curGuess);

        } while(!mrMan.isMaxGuess());

        // did you run out of guesses?
        if(mrMan.isMaxGuess()){
            System.out.println("You ran outta lives :(\n");
        }

        // see if they wanna play again
        char yesOrNo = getValidInput(in, validYNList, yesNoMessage);
        // make pretty line spacing
        System.out.println("\n");

        return (yesOrNo == 'y');
    }

    private static char getValidInput(Scanner scan, ArrayList<String> validChars, String prompt){
        // create a character to test
        String currentCharInput;
        // making sure the current response is valid
        do {
            System.out.print(prompt);
            String response = scan.nextLine();
            currentCharInput = "" + response.toLowerCase().charAt(0);

            if(!validChars.contains(currentCharInput)){
                System.out.println("You can do better. Try picking a valid character.");
            }
        } while(!validChars.contains(currentCharInput));

        return currentCharInput.charAt(0);
    }

    /*
     * Stolen from Ricky
     */
    private static void quit() {
        System.exit(0);
    }
}
