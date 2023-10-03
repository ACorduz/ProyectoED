package Estructure_DoubleLinkedList ;

public class Stack<T> extends DoubleLinkedList implements EstructureStack<T>{
    
    
    public Stack(){
       super();
    }
    
 
    public T peek(){
        boolean empty = empty();
        if (empty){
            throw new RuntimeException("Stack is empty");
        }else{
            return(T) (topBack());
        }
    }
   
    
    public void push(T item){
        pushBack(item);  
    }

    public T pop(){
        if (empty()){
            throw new RuntimeException("Stack is empty");
        }else{
            T output = (T) topBack();
            popBack();
            return(output);
        } 
    }
    

}
