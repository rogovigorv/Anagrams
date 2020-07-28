package com.foxminded.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static String read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sentence = null;

        try {
            sentence = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sentence;
    }
}
