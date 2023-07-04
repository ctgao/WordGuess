package com.github.zipcodewilmington;


import java.util.ArrayList;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    // hi i'm adding my name Christine Gao
    // final vars AKA constant
    private int MAX_GUESSES;
    // Keep track of the guesses
    private int guessNum;
    private ArrayList<Character> listOfGuesses;
    private String[] wordBank = {"freedom", "contract", "eternity", "wisdom", "justice", "war", "angst"};
    private String wordToGuess;

    /*
     * Constructor!
     */
    public Hangman(){
        guessNum = 0;
        listOfGuesses = new ArrayList<Character>();
        wordToGuess = wordBank[(int) (Math.random()*wordBank.length)];
        MAX_GUESSES = wordToGuess.length();
    }

    public boolean isNotMaxGuess() {
        return guessNum != MAX_GUESSES;
    }

    /*
     * Print dashes for letters not found and the letter itself for letters found.
     * This contains the bulk of the logic
     */
    public boolean printGuess() {
        boolean noDashes = true;

        // iterate through the string
        for(int i = 0; i < wordToGuess.length(); i++){
            char curLetter = wordToGuess.charAt(i);
            // If the guess is found, type the letter out
            if(listOfGuesses.contains(curLetter)){
                System.out.print(curLetter + " ");
            }
            else{
                System.out.print("_ ");
                noDashes = false;
            }
        }

        // if there are dashes AKA you haven't guessed the word, then print the guesses
        if(!noDashes) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nYou have ");
            sb.append(MAX_GUESSES - guessNum);
            sb.append(" tries left.\n");
            System.out.println(sb.toString());
        }

        return noDashes;
    }

    public void makeGuess(Character curGuess) {
        // you have already guessed this letter before
        if(listOfGuesses.contains(curGuess)){
            System.out.println("This was a previous guess!");
            return;
        }

        listOfGuesses.add(curGuess);
        // if the word doesn't contain the guess, then add one to the guess counter
        if(wordToGuess.indexOf(curGuess) == -1){
            guessNum++;
        }
    }
}
