package com.foxminded.anagram;

public class AnagramMaker {
    private static final String SPACE_DELIMITER = " ";

    public String makeAnagram(String sentence) {
        validate(sentence);

        final String[] words = sentence.split(SPACE_DELIMITER);
        final String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }

        return concat(reversedWords);
    }

    private String reverseWord(String word) {

        StringBuilder reverseWord = new StringBuilder();

        int letterShifter = word.length() - 1;
        for (int i = 0; i < word.length(); ++i) {
            if (Character.isLetter(word.charAt(i))) {
                while (!Character.isLetter(word.charAt(letterShifter))) {
                    letterShifter--;
                }
                reverseWord.append(word.charAt(letterShifter--));
            } else {
                reverseWord.append(word.charAt(i));
            }
        }

        return reverseWord.toString();
    }

    private void validate(String sentence) {

        if (sentence == null) {
            throw new InputSentenceException("Sentence is null");
        }
        if (sentence.isEmpty()) {
            throw new InputSentenceException("Sentence is empty");
        }
        if (sentence.trim().isEmpty()) {
            throw new InputSentenceException("Sentence is null or contains only tabulation symbols");
        }
    }

    private String concat(String[] reversedWords) {
        return String.join(SPACE_DELIMITER, reversedWords);
    }
}
