package Data;

public class Queue<T> extends LinkedList implements EstructureQueue<T> {
    
    public Queue(){
        super();
    }
    
    
    public void enqueue(T item){
        Comparable key = (Comparable) item; 
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
