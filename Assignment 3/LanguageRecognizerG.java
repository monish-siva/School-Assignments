
/**
 * 
 *
 * Monishkumar Sivakumar
 * 2020/03/08
 */
public class LanguageRecognizerG
{
    
    String str = "";
    
    public LanguageRecognizerG()
    {
 
    }
    
    //The purpose of this constructor is to put the string variable word into the string variable str.
    public LanguageRecognizerG(String word) {
        str = word;
    }
    
    //This function checks if the word follows E grammar. 
    private boolean isE(char inputs) {
	try {
		if(inputs == '#' || inputs == '&') {
			return true;
			
		}
		
		
	} catch(Exception e) {
	    
	    
		return false;
        }
        
        
		return false;
    }
    
    //This function checks if the word follows V grammar.
    private boolean isV(char input) {
	try {
	    
		if( input == 'A' || input == 'W') {
		    return true;
		    
		}
		
		
	} catch(Exception e) {
	    return false;
	    
	    
	}
	return false;
    }

    //This function checks if the word follows VE grammar.
    private boolean isVE(String input) {
        try { 
		if(isE(input.charAt(1)) && isV(input.charAt(0)) ) {
		    return true;
		    
		    
		}
	} catch(Exception e) {
	    return false;
	    
	}
	
	
	return false;
	
	
    }
	
    //This method uses the previous and below methods to validate the beginning and end of the word the user inputted. 
    //The method also recursively checks the middle of the word for G grammar.
    private boolean isEGV(String input) {
        try {
            
            
		if(input.length() > 2) {
		    
			if(isE(input.charAt(0)) && isV(input.charAt(input.length()-1)) && recursiveRecogG(input.substring(1, input.length()-2)).length() == 0) {
				return true;
				
                        }
                        
		} else {
		    
		    
			if(isE(input.charAt(0)) && isV(input.charAt(input.length()-1))) {
				return true;
				
				
                        }
		}			
	} catch(Exception e) {
	    
		return false;
        }
	return false;
    }
	
    //This method checks the string the user inputted to see if it is a word of the G language.
    public String recursiveRecogG(String input) {
	if(input.length() == 0) {
	    
		return "";
        } else if(isE(input.charAt(0)) && input.length()==1) {
		return "";
		
		
        } else if(isVE(input.substring(0, 2)) && input.length()==2) {
		
                return "";
		
        } else if(isEGV(input) && input.length() > 1) {
		
            
                return "";
                
                
        } else {
		 
                return "x"; //is NOT a word
        }
    }

    //This method prints out the result of the method recursiveRecogG.
    public void recursivePrintG() {
        
        if (recursiveRecogG(str).length() != 0) {
            
		System.out.println("Recursion: Word '"+ str +"' is NOT a word of the G language");
		
        } else {
            
            
		System.out.println("Recursion: Word '"+ str +"' IS a word of the G language");
        }
    }


}
