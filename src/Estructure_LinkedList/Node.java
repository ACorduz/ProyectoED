
package Estructure_LinkedList;

import java.io.Serializable;

public class Node<T> implements Serializable {
    
    private T data;
    private Node<T> next;
    
    public Node(){
        this(null); // llama al otro constructor como data = null
    }
    
    public Node(T data){
        this.data = data;
        next = null; // nodo siguiente nulo
    }
    
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return(this.data);
    }
    
    public Node getNext(){
        return(this.next);
    }
    
    public void setNext(Node next){
        this.next = next;
    }
}
