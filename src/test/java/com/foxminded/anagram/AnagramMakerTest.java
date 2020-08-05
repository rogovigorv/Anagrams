package com.foxminded.anagram;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramMakerTest {

    private final AnagramMaker anagramSentenceTest = new AnagramMaker();

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithOneNonLetterSymbol() {
        final String actual = anagramSentenceTest.makeAnagram("dty&b");
        final String expected = "byt&d";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithOneLetterSymbol() {
        final String actual = anagramSentenceTest.makeAnagram("!a#&%");
        final String expected = "!a#&%";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheSameLetterSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("aaa%a%");
        final String expected = "aaa%a%";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheSameNonLetterSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("!!!!");
        final String expected = "!!!!";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheDifferentLetterSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("abcdef");
        final String expected = "fedcba";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheDifferentNonLetterSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("!@#$%");
        final String expected = "!@#$%";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfOneWordWithTheDifferentLetterSymbolsInUpperAndLowerCases() {
        final String actual = anagramSentenceTest.makeAnagram("aBcDeF");
        final String expected = "FeDcBa";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfTwoWordsWithOnlyLetterSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("abcd htr");
        final String expected = "dcba rth";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfTwoWordsWithOnlyNonLetterSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("!@#$ %^&");
        final String expected = "!@#$ %^&";
        assertThat(actual , equalTo(expected));
    }

    @Test
    void makeAnagramShouldReturnAnagramOfThreeWordsWithDifferentSymbols() {
        final String actual = anagramSentenceTest.makeAnagram("abcd! Fgh% jK#ln");
        final String expected = "dcba! hgF% nl#Kj";
        assertThat(actual , equalTo(expected));
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
