package Estructure_LinkedList ;

public class Stack<T> extends LinkedList implements EstructureStack<T>{
    
    public Stack(){
        super();
    }
     
    public T peek(){
        boolean empty = empty();
        if (empty){
            throw new RuntimeException("Stack is empty");
        }else{
            return((T) topFront());
        }
    }
    
    public void push(T item){
        pushFront((Comparable) item);
       
    }

    public T pop(){
        if (empty()){
            throw new RuntimeException("Stack is empty");
        }else{
            T output = (T) topFront();
            popFront();
            return(output);
        } 
    }
    

}
