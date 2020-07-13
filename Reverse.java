package com.foxminded.anagrams;

public class Reverse {
		
	public String startReverse(String inputString) {
		String[] words = inputString.split(" ");
		String answer = "";
		
		for (int i = 0; i < words.length; i++) 
        {
			
			String word = words[i];
			answer = answer + reverseEachWordInaString(word) + " ";            
		}
		return answer;
	}	
	
	public String reverseEachWordInaString(String inputString) {
		     
		   StringBuilder reverseWord = new StringBuilder();		   
			   
			   int j = inputString.length() - 1;
			   		for (int i = 0; i < inputString.length(); ++i) {
			   			if (Character.isLetter(inputString.charAt(i))) {
			   				while (!Character.isLetter(inputString.charAt(j)))
	                    j--;
	                reverseWord.append(inputString.charAt(j--));
	            } else {
	            	reverseWord.append(inputString.charAt(i));
	            }
	        }
			   		return reverseWord.toString();

	   }	

}
