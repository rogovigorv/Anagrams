package com.foxminded.anagram;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnagramMakerTest {

    private final AnagramMaker anagramSentenceTest = new AnagramMaker();

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithOneNonLetterSymbol() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("dty&b"));
        final String expected = "byt&d";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithOneLetterSymbol() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("!a#&%"));
        final String expected = "!a#&%";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheSameLetterSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("aaa%a%"));
        final String expected = "aaa%a%";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheSameNonLetterSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("!!!!"));
        final String expected = "!!!!";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheDifferentLetterSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("abcdef"));
        final String expected = "fedcba";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheDifferentNonLetterSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("!@#$%"));
        final String expected = "!@#$%";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheDifferentLetterSymbolsInUpperAndLowerCases() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("aBcDeF"));
        final String expected = "FeDcBa";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfTwoWordsWithOnlyLetterSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("abcd htr"));
        final String expected = "dcba rth";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfTwoWordsWithOnlyNonLetterSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("!@#$ %^&"));
        final String expected = "!@#$ %^&";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldReturnAnagramOfThreeWordsWithDifferentSymbols() {
        final Matcher<String> actual = equalTo(anagramSentenceTest.makeAnagram("abcd! Fgh% jK#ln"));
        final String expected = "dcba! hgF% nl#Kj";
        assertThat(expected, actual);
    }

    @Test
    void makeAnagramShouldThrowInputSentenceExceptionWhenNullPassed() {
        InputSentenceException exception = assertThrows(InputSentenceException.class, () ->
            anagramSentenceTest.makeAnagram(null));
        assertThat("Sentence is null", equalTo(exception.getMessage()));
    }

    @Test
    void makeAnagramShouldThrowInputSentenceExceptionWhenEmptySentencePassed() {
        InputSentenceException exception = assertThrows(InputSentenceException.class, () ->
                anagramSentenceTest.makeAnagram(""));
        assertThat("Sentence is empty", equalTo(exception.getMessage()));
    }

    @Test
    void makeAnagramShouldThrowInputSentenceExceptionWhenSpacePassed() {
        InputSentenceException exception = assertThrows(InputSentenceException.class, () ->
                anagramSentenceTest.makeAnagram(" "));
        assertThat("Sentence is null or contains only tabulation symbols", equalTo(exception.getMessage()));
    }
}
