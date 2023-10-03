
package Estructure_DoubleLinkedList;

public class Node<T> {
    
    private T data;
    private Node<T> next;
    private Node<T> prev;
    
    public Node(){
        this(null); // llama al otro constructor como data = null
    }
    
    public Node(T data){
        this.data = data;
        next = null; // nodo siguiente nulo
        prev = null; 
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

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
    
}
