package com.github.zipcodewilmington;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {
    Hangman theHangman;
    String testerWord = "executioner";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        theHangman = new Hangman();
        theHangman.setWordToGuess(testerWord);
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    /*
     * Test function isNotMaxGuess()
     */
    @Test
    public void testIsNotMaxGuess1() {
        // first test to see if the guess is not maxed
        theHangman.setGuessNum(0);
        Assert.assertFalse(theHangman.isMaxGuess());
    }
    @Test
    public void testIsNotMaxGuess2() {
        // second test to see if the guess is not maxed
        theHangman.setGuessNum(3);
        Assert.assertFalse(theHangman.isMaxGuess());
    }
    @Test
    public void testIsNotMaxGuess3() {
        // test to see if the guess is maxed AKA equal to the length of the word
        theHangman.setGuessNum(testerWord.length());
        Assert.assertTrue(theHangman.isMaxGuess());
    }

    /*
     * Test printGuess()
     */
    @Test
    public void testPrintGuess1() {
        // set the guesses to an empty array list
        theHangman.clearListOfGuesses();
        Assert.assertFalse(theHangman.printGuess());
    }
    @Test
    public void testPrintGuess2() {
        // now set the guesses to some of the correct letters
        theHangman.clearListOfGuesses();
        theHangman.addToListOfGuesses('e','x','c','b','a');
        Assert.assertFalse(theHangman.printGuess());
    }
    @Test
    public void testPrintGuess3() {
        // now set the guesses to some of the correct letters
        theHangman.clearListOfGuesses();
        theHangman.addToListOfGuesses('e','x','c','u','t','i','o','n','r');
        Assert.assertTrue(theHangman.printGuess());
    }
}
