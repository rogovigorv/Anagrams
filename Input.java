package com.foxminded.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	public static String startInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = null;		
							
			try {					
				inputString = reader.readLine();			
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			return inputString;
		}

}
