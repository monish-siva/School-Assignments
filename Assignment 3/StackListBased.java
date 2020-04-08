import java.util.LinkedList;

class StackListBased<Object> {

    private LinkedList<Object> wChars;
    int size;
    //int top = "";

    StackListBased(){
        wChars = new LinkedList<>();
        
        
        
    }
 
    //Creates the stack
    void createStack() {
        wChars = new LinkedList<>();
        
        
        size = 0;
    }

    //Gets rid of all the objects in the stack
    void popAll() {
        size = 0;
        
        wChars.clear();
        
        
        
    }
 
    //Finds the size of the stack
    public int getSize() {
        return wChars.size();
        
        //size = size++;
    }

    //Checks if the stack is empty or if there is one
    boolean isEmpty() {
        return size == 0;
    }
    
    //Push adds an object to the end of the stack
    void push(Object e){
        wChars.push(e);
        //wchars
        size++;
    }
    
    
    //Gets rid of the object at the front of the stack
    Object pop() {
        size--;
        
        
        
        
        return wChars.pop();
        
    }

    //looks at the top of the stack
    Object peek() {
        
        
        
        
        
        return wChars.peek();
    }
}
