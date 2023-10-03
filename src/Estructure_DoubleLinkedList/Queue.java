package Estructure_DoubleLinkedList;

public class Queue<T> extends DoubleLinkedList implements EstructureQueue<T> {
    
    public Queue(){
        super();
    }
    
    public void enqueue(T key){
        pushFront(key);
    }
    
    public T peek(){
        return(T) (topFront());
    }
    
    public T dequeue(){
        if(empty()){
            throw new RuntimeException("Queue is empty");
        }else{
            T output = (T) topBack();
            popBack(); 
            return(output);
        }
    }
    
    
    
    
}
