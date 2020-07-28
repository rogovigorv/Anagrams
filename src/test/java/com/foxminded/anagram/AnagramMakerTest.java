package com.foxminded.anagram;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class AnagramMakerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final AnagramMaker anagramSentenceTest = new AnagramMaker();

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithOneNonLetterSymbol() {
        String inputedSentence = "dty&b";
        String reversedSentence = "byt&d";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithOneLetterSymbol() {
        String inputedSentence = "!a#&%";
        String reversedSentence = "!a#&%";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithTheSameLetterSymbols() {
        String inputedSentence = "aaa%a%";
        String reversedSentence = "aaa%a%";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithTheSameNonLetterSymbols() {
        String inputedSentence = "!!!!";
        String reversedSentence = "!!!!";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithTheDifferentLetterSymbols() {
        String inputedSentence = "abcdef";
        String reversedSentence = "fedcba";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithTheDifferentNonLetterSymbols() {
        String inputedSentence = "!@#$%";
        String reversedSentence = "!@#$%";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfOneWordWithTheDifferentLetterSymbols_InUpperAndLowerCases() {
        String inputedSentence = "aBcDeF";
        String reversedSentence = "FeDcBa";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfTwoWordsWithOnlyLetterSymbols() {
        String inputedSentence = "abcd htr";
        String reversedSentence = "dcba rth";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfTwoWordsWithOnlyNonLetterSymbols() {
        String inputedSentence = "!@#$ %^&";
        String reversedSentence = "!@#$ %^&";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldReturnAnagram_OfThreeWordsWithDifferentSymbols() {
        String inputedSentence = "abcd! Fgh% jK#ln";
        String reversedSentence = "dcba! hgF% nl#Kj";
        assertEquals(reversedSentence, anagramSentenceTest.makeAnagram(inputedSentence));
    }

    @Test
    public void makeAnagram_ShouldThrowInputSentenceException_WhenNullPassed() {
        expectedException.expect(InputSentenceException.class);
        expectedException.expectMessage("Sentence is null");
        anagramSentenceTest.makeAnagram(null);
    }

    @Test
    public void makeAnagram_ShouldThrowInputSentenceException_WhenEmptySentencePassed() {
        expectedException.expect(InputSentenceException.class);
        expectedException.expectMessage("Sentence is empty");
        anagramSentenceTest.makeAnagram("");
    }

    @Test
    public void makeAnagram_ShouldThrowInputSentenceException_WhenSpacePassed() {
        expectedException.expect(InputSentenceException.class);
        expectedException.expectMessage("Sentence is null or contains only tabulation symbols");
        anagramSentenceTest.makeAnagram(" ");
    }
}
