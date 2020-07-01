package experiment;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
		
		
		
		//System.out.println(getAlphaNumericString());
	
	}
	
	
	public static String randomAddress()
	{
		return RandomStringUtils.randomAlphanumeric(6);
	}
	
	
	
	
	
	
	
	
	public static String randomAlphabets()
	{
		return RandomStringUtils.randomAlphabetic(7).toLowerCase();
	}
		
	public static String randomPhoneNumber()
	{
		return RandomStringUtils.randomNumeric(10);
	}
	
	
		static String getAlphaNumericString() 
	    { 
	  
	        // chose a Character random from this String 
	        String alphabhets =  "abcdefghijklmnopqrstuvxyz"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(6); 
	  
	        for (int i = 0; i < 6; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(alphabhets.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(alphabhets
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    }
	
	
	
	
	}


