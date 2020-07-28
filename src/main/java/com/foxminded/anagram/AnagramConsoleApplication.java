package com.foxminded.anagram;

public class AnagramConsoleApplication {
    public static void main(String[] args) {
        AnagramMaker anagram = new AnagramMaker();
        System.out.print(anagram.makeAnagram(Input.read()));
    }
}
