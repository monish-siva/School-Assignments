import java.util.*;
import java.util.List;

public class InfixCalculator extends StackListBased {
    String expInput;
    
    String[] exp;
	
    //It gets the infix string so that we can print it
    public InfixCalculator(String input) {
        expInput = input;
        
	exp = input.trim().split("\\s+");
	
	
	
	System.out.println(exp[1]);		
    }
    
    //this method finds what operation we need
    private int operation(char c){
        if(c=='+'|| c=='-') {
            return 1;
        }
        
        else if(c=='*' || c=='/') {
            return 2;
        }
        
        else {
            return -1;
        }
        
    }
    
    //finds the value of the postfix equation
    private int getPostFix(List<String> postFixList){
        Stack<Integer> stacks = new Stack<>();
        
        for(int j=0;j<postFixList.size();j++){
            String wordInput = postFixList.get(j);
            
            if(wordInput.length()==1 && (wordInput.charAt(0)=='+'||wordInput.charAt(0)=='-'||wordInput.charAt(0)=='*'||wordInput.charAt(0)=='/')){
                int number2 = stacks.pop();
                
                int number1 = stacks.pop();
                
                if(wordInput.charAt(0)=='+'){
                    
                    int number = number1+number2;
                    
                    stacks.push(number);
                    
                }
                else if(wordInput.charAt(0)=='*'){
                    int number = number1*number2;
                    stacks.push(number);
                    
                }else if(wordInput.charAt(0)=='-'){
                    
                    int number = number1-number2;
                    
                    stacks.push(number);
                    

                }else{
                    
                    int number = number1/number2;
                    
                    stacks.push(number);
                    
                }
            }else{
                
                int number = Integer.parseInt(wordInput);
                
                stacks.push(number);
                
            }
            
        }
        
        return stacks.peek();
    }
    
    /*
    	public char getPostfix() {
		StackListBased r = new StackListBased();
		String[] postFixArr = postFix.trim().split("\\s+");
		r.createStack();
		
		for(int i = 0; i < postFix.length(); i++) {
			char x = postFix.charAt(i); 
			
			if(Character.isDigit(x)) {
				
				if(i+1 >= postFix.length() || !Character.isDigit(postFix.charAt(i+1))) {
					postFix += ' ';
				}
				r.push(x);
			} else {
				int a = r.pop() - '0';
				int b = r.pop() - '0';
				
				switch(x) {
					case '-':
						r.push((char) (b - a));
						break;
					case '+':
						r.push((char) (a + b));
						break;
					case '/':
						r.push((char) (b / a));
						break;
					case '*':
						r.push((char) (a * b));
						break;
				}
			}
		}
		return (r.pop());
		
	} */
	
	
    // converts the infix string to postfix
    private List<String> convertPostFix(String s){
        Stack<Character> wordStack = new Stack<>();
        
        
        List<String> postFixList = new ArrayList<>();
        
        boolean flagCheck = false;
        
        
        for(int i=0;i<s.length();i++){
            
            char words = s.charAt(i);
            if(words ==' '){
                continue;
                
            }
            
            
            if(words =='('){
                
                wordStack.push(words);
                flagCheck = false;
                
                
            }else if(words==')'){
                flagCheck = false;
                
                while(!wordStack.isEmpty()){
                    if(wordStack.peek()=='('){
                        
                        wordStack.pop();
                        
                        
                        break;
                    }else{
                        postFixList.add(wordStack.pop()+"");
                    }
                    
                }
                
            }else if(words =='+' || words =='-' || words =='*' || words =='/'){
                flagCheck = false;
                
                if(wordStack.isEmpty()){
                    wordStack.push(words);
                }
                else{
                    while(!wordStack.isEmpty() && operation(wordStack.peek())>=operation(words)){
                        postFixList.add(wordStack.pop()+"");
                    }
                    wordStack.push(words);
                }
            }else{
                if(flagCheck){
                    String lNumber = postFixList.get(postFixList.size()-1);
                   
                    lNumber += words;
                    
                    postFixList.set(postFixList.size()-1, lNumber);
                }else
                postFixList.add(words + "");
                flagCheck = true;
            }
        }
        while(!wordStack.isEmpty()){
            
            
            postFixList.add(wordStack.pop()+"");
        }
        
        
        return postFixList;
    }
    public void evaluateInfix(String s) {
        	List<String> postFixString = convertPostFix(s);
        	
        	
		System.out.println("infix: " + expInput);
		
		System.out.println("postfix: " + postFixString);
		
		System.out.println("result: " + getPostFix(postFixString));
		
     }
}

