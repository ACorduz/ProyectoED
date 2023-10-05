package Estructure_LinkedList;

import java.io.Serializable;

public class Queue<T> extends LinkedList implements EstructureQueue<T>,  Serializable {
    
    public Queue(){
        super();
    }
    
    
    public void enqueue(T key){
        pushBack(key);

    }
    
    public T dequeue(){
        if(empty()){
            throw new RuntimeException("Queue is empty");
        }else{
            T output = (T) topFront();
            popFront(); 
            return(output);
        }
    }
    
    
    
}
