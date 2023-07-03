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
    private final int MAX_GUESSES = 4;
    // Keep track of the guesses
    private int guessNum;
    private ArrayList<Character> listOfGuesses;
    private String[] wordBank = {"freedom", "contract", "eternity", "wisdom", "justice", "war", "angst"};

    /*
     * Constructor!
     */
    public Hangman(){
        guessNum = 0;
        listOfGuesses = new ArrayList<Character>();
    }

    public boolean isNotMaxGuess() {
        return guessNum != MAX_GUESSES;
    }

    /*
     * Print dashes for letters not found and the letter itself for letters found.
     */
    public boolean printGuess() {
        return false;
    }

    public void makeGuess(Character curGuess) {
        // you have already guessed this letter before
        if(listOfGuesses.contains(curGuess)){
            System.out.println("This was a previous guess!");
            return;
        }

        listOfGuesses.add(curGuess);
        guessNum += 1;
    }
}
