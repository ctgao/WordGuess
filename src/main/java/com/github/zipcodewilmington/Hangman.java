package com.github.zipcodewilmington;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    // hi i'm adding my name Christine Gao
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
        this.guessNum = 0;
        this.listOfGuesses = new ArrayList<Character>();
        this.wordToGuess = this.wordBank[(int) (Math.random()*this.wordBank.length)];
        this.MAX_GUESSES = this.wordToGuess.length();
    }
    /*
     * The getters for the tester function.
     */
    public void setWordToGuess(String input) {
        this.wordToGuess = input;
        this.MAX_GUESSES = input.length();
    }
    public void setGuessNum(int input){
        this.guessNum = input;
    }
    public void addToListOfGuesses(char[] arrayOfChars){
        for(char c : arrayOfChars){
            listOfGuesses.add(c);
        }
    }
    public void clearListOfGuesses(){
        listOfGuesses.clear();
    }

    /*
     * The functions after this are for the Main function to use
     */
    public boolean isMaxGuess() {
        return this.guessNum == this.MAX_GUESSES;
    }

    /*
     * Print dashes for letters not found and the letter itself for letters found.
     * This contains the bulk of the logic
     */
    public boolean printGuess() {
        boolean noDashes = true;

        // iterate through the string
        for(int i = 0; i < this.wordToGuess.length(); i++){
            char curLetter = this.wordToGuess.charAt(i);
            // If the guess is found, type the letter out
            if(this.listOfGuesses.contains(curLetter)){
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
            sb.append(this.MAX_GUESSES - this.guessNum);
            sb.append(" tries left.\n");
            System.out.println(sb.toString());
        }

        return noDashes;
    }

    public void makeGuess(Character curGuess) {
        // you have already guessed this letter before
        if(this.listOfGuesses.contains(curGuess)){
            System.out.println("This was a previous guess!");
            return;
        }

        this.listOfGuesses.add(curGuess);
        // if the word doesn't contain the guess, then add one to the guess counter
        if(this.wordToGuess.indexOf(curGuess) == -1){
            this.guessNum++;
        }
    }
}
